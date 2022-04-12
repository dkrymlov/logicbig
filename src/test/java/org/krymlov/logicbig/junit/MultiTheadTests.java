package org.krymlov.logicbig.junit;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.krymlov.logicbig.AbstractTest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class MultiTheadTests extends AbstractTest {

    public static final int CAPACITY = 25_000_000;
    AtomicInteger ai = new AtomicInteger();
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(CAPACITY);

    long timeMillis;

    @BeforeAll
    void beforeAll(){
        timeMillis = System.currentTimeMillis();
    }

    @AfterAll
    void afterAll(){
        long l = System.currentTimeMillis() - timeMillis;
        System.out.println(l);
        System.out.println(concurrentHashMap.size());
    }

    @Order(2)
    @RepeatedTest(100)
    void test(RepetitionInfo info) {
        final int length = CAPACITY / info.getTotalRepetitions();

        for (int i = 0; i < length; i++) {
            concurrentHashMap.put(ai.incrementAndGet(), info);
        }
        //System.out.println(Thread.currentThread().getName());
    }

}
