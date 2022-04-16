package org.krymlov.logicbig.binary;

public class Binary {

    private Binary(){};

    public static int countBits(byte value){
        value = 1;
        int i = 0;
        while (value > 0){
            value = (byte) (value << 1);
            i++;
        }
        return i+1;
    }

    public static int countBits(short value){
        value = 1;
        int i = 0;
        while (value > 0){
            value = (short) (value << 1);
            i++;
        }
        return i+1;
    }

    public static int countBits(int value){
        value = 1;
        int i = 0;
        while (value > 0){
            value = (value << 1);
            i++;
        }
        return i+1;
    }

    public static int countBits(long value){
        value = 1;
        int i = 0;
        while (value > 0){
            value = (value << 1);
            i++;
        }
        return i+1;
    }

}
