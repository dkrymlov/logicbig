package org.krymlov.logicbig.junit;

import com.google.common.cache.*;
import org.junit.jupiter.api.*;
import org.krymlov.logicbig.guava.Human;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class GuavaCacheTests {

    private static Cache<Integer, Human> cache = CacheBuilder.newBuilder()
            .initialCapacity(5)
            .concurrencyLevel(5)
            .maximumSize(5)
            .build();

    static int index = 0;
    static long timeMillis;
    static ConcurrentMap<Integer, Human> humans = new ConcurrentHashMap<>();

    @BeforeAll
    static void beforeAll(){
        initMap();
        cache.asMap().putAll(humans);

        System.out.println("Entities in actual map : " + humans);
        System.out.println("Entities in cache : " + cache.asMap());

        timeMillis = System.currentTimeMillis();
    }

    @AfterAll
    static void afterAll(){
        long l = System.currentTimeMillis() - timeMillis;
        System.out.println("Tests working time is " + l + " millis");
        System.out.println("Entities in cache after accessing : " + cache.asMap());
    }

    static void initMap(){
        humans.put(++index, new Human(19, "Danil"));
        humans.put(++index,new Human(23, "David"));
        humans.put(++index,new Human(20, "Taya"));
        humans.put(++index,new Human(17, "Stasya"));
        humans.put(++index,new Human(19, "Nikita"));
    }

    <T> T getAndClear(Integer key, Cache<Integer, T> cache){
        T object = cache.asMap().get(key);
        cache.asMap().remove(key);
        return object;
    }

    @Order(2)
    @RepeatedTest(5)
    void test(RepetitionInfo info) throws InterruptedException {
        Assertions.assertEquals(humans.get(info.getCurrentRepetition()), getAndClear(info.getCurrentRepetition(), cache));
    }

}
