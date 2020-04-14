package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheServiceImpl implements CacheService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    @SuppressWarnings(value = "unchecked")
    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, long sec) {
        redisTemplate.opsForValue().set(key, value, sec);
    }

    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Long delete(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public Boolean expire(String key, long sec) {
        return redisTemplate.expire(key, sec, TimeUnit.SECONDS);
    }

    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public Long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T hashGet(String key, Object hashKey) {
        return (T) redisTemplate.opsForHash().get(key, hashKey);
    }

    @Override
    public void hashSet(String key, String hashKey, Object value, long sec) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        expire(key, sec);
    }

    @Override
    public void hashSet(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    @Override
    public Map<Object, Object> hashGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public void hashSetAll(String key, Map<String, Object> map, long sec) {
        redisTemplate.opsForHash().putAll(key, map);
        expire(key, sec);
    }

    @Override
    public void hashSetAll(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public void hashDel(String key, Object... hasKey) {
        redisTemplate.opsForHash().delete(key, hasKey);
    }

    @Override
    public Boolean hasHashKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key,hashKey);
    }

    @Override
    public Long hashIncr(String key, String hashKey, long delta) {
        return redisTemplate.opsForHash().increment(key,hashKey,delta);
    }

    @Override
    public Long hashDecr(String key, String hashKey, long delta) {
        return redisTemplate.opsForHash().increment(key,hashKey,-delta);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Set<T> sMembers(String key) {
        return (Set<T>) redisTemplate.opsForSet().members(key);
    }

    @Override
    public void sAdd(String key, long sec, Object... values) {
redisTemplate.opsForSet().add(key,values);
expire(key,sec);
    }

    @Override
    public void sIsMember(String key, Object value) {
redisTemplate.opsForSet().isMember(key,value);
    }

    @Override
    public Long sSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    @Override
    public void sRemove(String key, Object... values) {
        redisTemplate.opsForSet().remove(key,values);
    }

    @Override
    public List<Object> lRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key,start,end);
    }

    @Override
    public Long lSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public Object lIndex(String key, long index) {
        return redisTemplate.opsForList().index(key,index);
    }

    @Override
    public Long lPush(String key, Object value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    @Override
    public Long lPush(String key, Object value, long sec) {
        Long index=redisTemplate.opsForList().leftPush(key,value);
        expire(key,sec);
        return index;
    }

    @Override
    public Long lPushAll(String key, Object... values) {
        return redisTemplate.opsForList().leftPushAll(key, values);
    }

    @Override
    public Long lPushAll(String key, long sec, Object... values) {
        Long index= redisTemplate.opsForList().leftPushAll(key,values);
        expire(key, sec);
        return index;
    }

    @Override
    public Object lPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    @Override
    public Long lRemove(String key, long count, Object value) {
        return redisTemplate.opsForList().remove(key,count,value);
    }

    @Override
    public void flushdb() {
        Set<String> keys = redisTemplate.keys("*");
        if (keys != null) {
            redisTemplate.delete(keys);
        }
    }

}
