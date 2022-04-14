package org.krymlov.logicbig.junit;

import org.junit.jupiter.api.*;
import org.krymlov.logicbig.AbstractTest;

import java.util.Random;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.*;

public class MathTests extends AbstractTest {

    static final Random random = new Random();
    public static final int CAPACITY = 250_000_000;

    @Test
    void testNaN() {
        Assertions.assertFalse(NaN == NaN);
    }

    @Test
    void testINF() {
        Assertions.assertTrue(POSITIVE_INFINITY == POSITIVE_INFINITY);
    }

    /*
    Returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer. Special cases:
If the argument value is already equal to a mathematical integer, then the result is the same as the argument.
If the argument is NaN or an infinity or positive zero or negative zero, then the result is the same as the argument.
     */
    @Test
    void testFloor() {
        Assertions.assertEquals(floor(5.3), 5);
        Assertions.assertEquals(floor(5.49), 5);
        Assertions.assertEquals(floor(5.7), 5);
        Assertions.assertEquals(floor(0.1), 0);
        Assertions.assertEquals(floor(10000.1), 10000);
        Assertions.assertEquals(floor(5000.91), 5000);
        Assertions.assertEquals(floor(0.75), 0);
        Assertions.assertEquals(floor(0.49), 0);
    }

    /*
    Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer. Special cases:
    If the argument value is already equal to a mathematical integer, then the result is the same as the argument.
    If the argument is NaN or an infinity or positive zero or negative zero, then the result is the same as the argument.
    If the argument value is less than zero but greater than -1.0, then the result is negative zero.
    Note that the value of Math.ceil(x) is exactly the value of -Math.floor(-x).
     */
    @Test
    void testCeil() {
        Assertions.assertEquals(ceil(5.3), 6);
        Assertions.assertEquals(ceil(5.49), 6);
        Assertions.assertEquals(ceil(5.7), 6);
        Assertions.assertEquals(ceil(0.1), 1);
        Assertions.assertEquals(ceil(10000.1), 10001);
        Assertions.assertEquals(ceil(5000.91), 5001);
        Assertions.assertEquals(ceil(0.75), 1);
        Assertions.assertEquals(ceil(0.49), 1);
    }

    @Test
    void testRound() {
        Assertions.assertEquals(round(5.3), 5);
        Assertions.assertEquals(round(5.49), 5);
        Assertions.assertEquals(round(5.7), 6);
        Assertions.assertEquals(round(0.1), 0);
        Assertions.assertEquals(round(10000.1), 10000);
        Assertions.assertEquals(round(5000.91), 5001);
        Assertions.assertEquals(round(0.75), 1);
        Assertions.assertEquals(round(0.49), 0);
    }

    @Test
    void testCast() {
        Assertions.assertEquals((int)(5.3), (int)floor(5));
        Assertions.assertEquals((int)(5.49), (int)floor(5));
        Assertions.assertEquals((int)(5.7), (int)round(5));
        Assertions.assertEquals((int)(0.1), (int)floor(0));
        Assertions.assertEquals((int)(10000.1), (int)floor(10000));
        Assertions.assertEquals((int)(5000.91), (int)round(5000));
        Assertions.assertEquals((int)(0.75), (int)round(0));
        Assertions.assertEquals((int)(0.49), (int)floor(0));
    }

    @Test
    void testPerfRound() {
        for (int i = 0; i < CAPACITY; i++) {
            Math.round(random.nextDouble() * CAPACITY);
        }
    }

    @Test
    void testPerfCeil() {
        for (int i = 0; i < CAPACITY; i++) {
            Math.ceil(random.nextDouble() * CAPACITY);
        }
    }

    @Test
    void testPerfFloor() {
        for (int i = 0; i < CAPACITY; i++) {
            Math.floor(random.nextDouble() * CAPACITY);
        }
    }


}
