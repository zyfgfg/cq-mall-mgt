package club.banyuan.cqmall.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CacheService {

     /**
      *k-v
      */
     <T> T get(String key);

     void set(String key, Object value);

     void set(String key, Object value, long sec);

     Boolean delete(String key);

     Long delete(List<String> keys);

     Long getExpire(String key);

     Boolean expire(String key, long sec);

     Boolean hasKey(String key);

     Long incr(String key, long delta);

     Long decr(String key, long delta);

     /**
      * @param hashKey
      */
     <T> T hashGet(String key, Object hashKey);

     void hashSet(String key, String hashKey, Object value, long sec);

     void hashSet(String key, String hashKey, Object value);

     Map<Object,Object> hashGetAll(String key);

     void hashSetAll(String key, Map<String, Object> map, long sec);

     void hashSetAll(String key, Map<String, Object> map);

     void hashDel(String key, Object... hasKey);

     Boolean hasHashKey(String key, String hashKey);

     Long hashIncr(String key, String hashKey, long delta);

     Long hashDecr(String key, String hashKey, long delta);

     /**
      * set
      */
     <T> Set<T> sMembers(String key);

     void sAdd(String key, long sec, Object... values);

     void sIsMember(String key, Object value);

     Long sSize(String key);

     void sRemove(String key, Object... values);

     /**
      *list
      */
     List<Object> lRange(String key, long start, long end);

     Long lSize(String key);

     Object lIndex(String key, long index);

     Long lPush(String key, Object value);

     Long lPush(String key, Object value, long sec);

     Long lPushAll(String key, Object... values);

     Long lPushAll(String key, long sec, Object... values);

     Object lPop(String key);

     Long lRemove(String key, long count, Object value);

     void flushdb();
}
