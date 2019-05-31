package com.order.service.redis;

import com.domain.redis.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class RedisLockService {
    private final static long LOCK_EXPIRE = 2 * 1000L;//单个业务持有锁的时间2s，防止死锁
    private final static long LOCK_TRY_INTERVAL = 100L;//默认100ms尝试一次
    private final static long LOCK_TRY_TIMEOUT = 1 * 1000L;//默认尝试1s

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 尝试获取全局锁
     *
     * @param lock 锁的名称
     * @return true 获取成功，false获取失败
     */
    public boolean tryLock(RedisLock lock) {
        return getLock(lock, LOCK_TRY_TIMEOUT, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock    锁的名称
     * @param timeout 获取超时时间 单位ms
     * @return true 获取成功，false获取失败
     */
    public boolean tryLock(RedisLock lock, long timeout) {
        return getLock(lock, timeout, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock        锁的名称
     * @param timeout     获取锁的超时时间
     * @param tryInterval 多少毫秒尝试获取一次
     * @return true 获取成功，false获取失败
     */
    public boolean tryLock(RedisLock lock, long timeout, long tryInterval) {
        return getLock(lock, timeout, tryInterval, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock           锁的名称
     * @param timeout        获取锁的超时时间
     * @param tryInterval    多少毫秒尝试获取一次
     * @param lockExpireTime 锁的过期
     * @return true 获取成功，false获取失败
     */
    public boolean tryLock(RedisLock lock, long timeout, long tryInterval, long lockExpireTime) {
        return getLock(lock, timeout, tryInterval, lockExpireTime);
    }


    /**
     * 操作redis获取全局锁
     *
     * @param lock           锁的名称
     * @param timeout        获取的超时时间
     * @param tryInterval    多少ms尝试一次
     * @param lockExpireTime 获取成功后锁的过期时间
     * @return true 获取成功，false获取失败
     */
    public boolean getLock(RedisLock lock, long timeout, long tryInterval, long lockExpireTime) {
        try {
            if (StringUtils.isEmpty(lock.getName())) {
                return false;
            }
            long startTime = System.currentTimeMillis();
            do {
//                synchronized (lock){//这个只能锁单机的
                    if (!redisTemplate.hasKey(lock.getName())) {
                        redisTemplate.opsForValue().set(lock.getName(), lock.getName(), lockExpireTime, TimeUnit.MILLISECONDS);
                        log.info("获得锁时间：" + System.currentTimeMillis());
                        return true;
                    } else {//存在锁
                        log.info("lock is exist!！！");
                    }
//                }
                if (System.currentTimeMillis() - startTime > timeout) {//尝试超过了设定值之后直接跳出循环
                    return false;
                }
                Thread.sleep(tryInterval);
            }while (true);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock 锁的名称
     * @return true 获取成功，false获取失败
     */
    public boolean tryLockBySetnx(RedisLock lock) {
        return getLockBySetnx(lock, LOCK_TRY_TIMEOUT, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock    锁的名称
     * @param timeout 获取超时时间 单位ms
     * @return true 获取成功，false获取失败
     */
    public boolean tryLockBySetnx(RedisLock lock, long timeout) {
        return getLockBySetnx(lock, timeout, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock        锁的名称
     * @param timeout     获取锁的超时时间
     * @param tryInterval 多少毫秒尝试获取一次
     * @return true 获取成功，false获取失败
     */
    public boolean tryLockBySetnx(RedisLock lock, long timeout, long tryInterval) {
        return getLock(lock, timeout, tryInterval, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock           锁的名称
     * @param timeout        获取锁的超时时间
     * @param tryInterval    多少毫秒尝试获取一次
     * @param lockExpireTime 锁的过期
     * @return true 获取成功，false获取失败
     */
    public boolean tryLockBySetnx(RedisLock lock, long timeout, long tryInterval, long lockExpireTime) {
        return getLockBySetnx(lock, timeout, tryInterval, lockExpireTime);
    }

    public boolean getLockBySetnx(RedisLock lock, long timeout, long tryInterval, long lockExpireTime) {
        try {
            if (StringUtils.isEmpty(lock.getName())) {
                return false;
            }
            long startTime = System.currentTimeMillis();
            while (!redisTemplate.opsForValue().setIfAbsent(lock.getName(), lock.getValue(), lockExpireTime, TimeUnit.MILLISECONDS)){
//                log.info("lock is exist!！！");
                if (System.currentTimeMillis() - startTime > timeout) {//尝试超过了设定值之后直接跳出循环
                    return false;
                }
                Thread.sleep(tryInterval);
            }
            log.info("获得锁时间：" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 释放锁
     */
    public void releaseLock(RedisLock lock) {
        if (!StringUtils.isEmpty(lock.getName())) {
            log.info("释放锁时间：" + System.currentTimeMillis());
        	redisTemplate.delete(lock.getName());
        }
    }

}
