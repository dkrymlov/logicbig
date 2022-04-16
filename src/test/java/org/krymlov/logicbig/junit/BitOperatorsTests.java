package org.krymlov.logicbig.junit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.krymlov.logicbig.AbstractTest;
import org.krymlov.logicbig.binary.Binary;

@Execution(ExecutionMode.SAME_THREAD)
public class BitOperatorsTests extends AbstractTest {

    public static String toBinary(int x, int len)
    {
        final char[] buff = new char[len];

        for (int i = len - 1; i >= 0 ; i--)
        {
            int mask = 1 << i;
            buff[len - 1 - i] = (x & mask) != 0 ? '1' : '0';
        }

        return new String(buff);
    }

    @Test
    void testMultiplicationByTwoWithShift1(){
        int value = 1;
        for (int i = 0; i < 8; i++) {
            value = value << 1;
            System.out.println(value);
        }
    }

    @Order(2)
    @RepeatedTest(9)
    void testMultiplicationByTwoWithShift2(RepetitionInfo info){
        byte value = 1;
        value = (byte) (value << info.getCurrentRepetition());
        System.out.println(value + " -> " + toBinary(value, 8));
    }

    @Order(2)
    @RepeatedTest(8)
    void testDivisionByTwoWithShift3(RepetitionInfo info){
        byte value = 127;
        byte result = (byte) (value >> info.getCurrentRepetition());
        System.out.print(value + " -> " + toBinary(value, 8) + "\t");
        System.out.println(result + " -> " + toBinary(result, 8));
    }

    @Order(2)
    @RepeatedTest(8)
    void testDivisionByTwoWithShift4(RepetitionInfo info){
        short value = Short.MAX_VALUE;
        value = (short) (value >> info.getCurrentRepetition());
        System.out.println("" + value + " -> " + toBinary(value, 16));
    }

    @Order(2)
    @RepeatedTest(8)
    void testOverloadWithShift5(RepetitionInfo info){
        short value = Short.MAX_VALUE;
        value = (short) (value >> info.getCurrentRepetition());
        System.out.println("" + value + " -> " + toBinary(value, 16));
    }

    @Test
    void testMinToMax(){
        final byte min = -64;
        byte result = (byte) (min >> 1);
        System.out.print(min + " -> " + toBinary(min, 8) + "\t");
        System.out.println(result + " -> " + toBinary(result, 8));
    }

    @Test
    void countBits(){
        byte _byte = -60;
        short _short = -222;
        int _int = -245566;
        long _long = -4567765;
        System.out.println(Binary.countBits(_byte));
        System.out.println(Binary.countBits(_short));
        System.out.println(Binary.countBits(_int));
        System.out.println(Binary.countBits(_long));
    }





}
