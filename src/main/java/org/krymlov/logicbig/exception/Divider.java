package org.krymlov.logicbig.exception;

public class Divider {

    private Divider(){}

    public static int divide(int a, int b) throws DividerException {
        if (b == 0){
            throw new DividerException("Divider can not be " + b);
        }else return (a / b);
    }

}
