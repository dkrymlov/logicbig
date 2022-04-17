package org.krymlov.logicbig.cppnative;

public class CppNativeExecutor {

    private static final CppNativeExecutor EXECUTOR = new CppNativeExecutor();

    private CppNativeExecutor(){
        System.loadLibrary("logicbig");
    }

    public static CppNativeExecutor getInstance(){
        return EXECUTOR;
    }

    public native long sum(int a, int b);
    public native String concat(String string, StringBuilder sb);
    public native long factorial(int n);

}
