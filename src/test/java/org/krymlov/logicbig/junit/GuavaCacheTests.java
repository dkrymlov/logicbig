package org.krymlov.logicbig.junit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.jupiter.api.*;
import org.krymlov.logicbig.AbstractTest;
import org.krymlov.logicbig.guava.Human;

import java.util.concurrent.ExecutionException;

public class GuavaCacheTests extends AbstractTest {
    static LoadingCache<Integer, Human> cache;

    @BeforeAll
    static void beforeAll() {
        CacheLoader<Integer, Human> loader = new CacheLoader<>() {
            @Override
            public Human load(Integer age) {
                Human human = new Human(age, "Name" + age);
                System.out.println(human);
                return human;
            }
        };

        cache = CacheBuilder.newBuilder().build(loader);
    }

    <T> T getAndClear(Integer key, Cache<Integer, T> cache) {
        T object = cache.asMap().get(key);
        cache.asMap().remove(key);
        return object;
    }

    @Order(2)
    @RepeatedTest(5)
    void test1(RepetitionInfo info) throws ExecutionException {
        Human human1 = cache.get(info.getCurrentRepetition());
        Human human2 = cache.get(info.getCurrentRepetition());
        Assertions.assertTrue(human1 == human2);
    }

    @Order(2)
    @RepeatedTest(5)
    void test2(RepetitionInfo info) throws ExecutionException {
        Human human1 = cache.get(info.getCurrentRepetition());
        Human human2 = cache.get(info.getCurrentRepetition());
        Assertions.assertTrue(human1 == human2);
    }

}