package com.product.service.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.domain.redis.RedisLock;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RedisLockService {
    private final static long LOCK_EXPIRE = 2 * 1000L;//单个业务持有锁的时间2s，防止死锁
    private final static long LOCK_TRY_INTERVAL = 50L;//默认30ms尝试一次
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
            if (StringUtils.isEmpty(lock.getName()) || StringUtils.isEmpty(lock.getValue())) {
                return false;
            }
            long startTime = System.currentTimeMillis();
            {
                if (!redisTemplate.hasKey(lock.getName())) {
                    redisTemplate.opsForValue().set(lock.getName(), lock.getValue(), lockExpireTime, TimeUnit.MILLISECONDS);
                    return true;
                } else {//存在锁
                    log.debug("lock is exist!！！");
                }
                if (System.currentTimeMillis() - startTime > timeout) {//尝试超过了设定值之后直接跳出循环
                    return false;
                }
                Thread.sleep(tryInterval);
            }
            while (redisTemplate.hasKey(lock.getName())) ;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            return false;
        }
        return false;
    }

    /**
     * 释放锁
     */
    public void releaseLock(RedisLock lock) {
        if (!StringUtils.isEmpty(lock.getName())) {
        	redisTemplate.delete(lock.getName());
        }
    }

}
