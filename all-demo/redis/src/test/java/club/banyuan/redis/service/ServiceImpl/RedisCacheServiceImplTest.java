package club.banyuan.redis.service.ServiceImpl;

import club.banyuan.redis.service.CacheService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisCacheServiceImplTest {

    @Autowired
    CacheService cacheService;

    @Test
    void get() {
        Integer age=cacheService.get("age");
        System.out.println(age);
        Integer weight=cacheService.get("weight");
        System.out.println(weight);
    }

    @Test
    void set() {
    }

    @Test
    void testSet() {
    }

    @Test
    void delete() {
        cacheService.delete("test");
        String test=cacheService.get("test");
        Assert.assertEquals("test",test);
    }

    @Test
    void testDelete() {
    }

    @Test
    void getExpire() {
    }

    @Test
    void expire() {
    }

    @Test
    void hasKey() {
    }

    @Test
    void incr() {
    }

    @Test
    void decr() {
    }

    @Test
    void hashGet() {
    }

    @Test
    void hashSet() {
    }

    @Test
    void testHashSet() {
    }

    @Test
    void hashGetAll() {
    }

    @Test
    void hashSetAll() {
    }

    @Test
    void testHashSetAll() {
    }

    @Test
    void hashDel() {
    }

    @Test
    void hasHashKey() {
    }

    @Test
    void hashIncr() {
    }

    @Test
    void hashDecr() {
    }

    @Test
    void sMembers() {
    }

    @Test
    void sAdd() {
    }

    @Test
    void sIsMember() {
    }

    @Test
    void sSize() {
    }

    @Test
    void sRemove() {
    }

    @Test
    void lRange() {
    }

    @Test
    void lSize() {
    }

    @Test
    void lIndex() {
    }

    @Test
    void lPush() {
    }

    @Test
    void testLPush() {
    }

    @Test
    void lPushAll() {
    }

    @Test
    void testLPushAll() {
    }

    @Test
    void lPop() {
    }

    @Test
    void lRemove() {
    }

    @Test
    void flushdb() {
    }
}