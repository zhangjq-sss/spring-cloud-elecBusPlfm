/**
 * 
 */
package com.common.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public abstract class CacheHelper {
	private static final Log log = LogFactory.getLog(CacheHelper.class);
	private static final ConcurrentHashMap<String, FutureTask<?>> helperMap = new ConcurrentHashMap<String, FutureTask<?>>();
	private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 200,
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());
	@SuppressWarnings("unchecked")
	public static <T> T execute(String key, FutureTask<T> task){
		FutureTask<?> futureTask = null;
		futureTask = (FutureTask<?>) helperMap.putIfAbsent(key, task);
		if(futureTask == null){
			futureTask = task;
			executor.execute(futureTask);
		}
		try {
			return (T) futureTask.get();
		} catch (Exception e) {
			log.error(e);
			throw new RuntimeException(e);
		}finally{
			helperMap.remove(key, futureTask);
		}
	}
}
