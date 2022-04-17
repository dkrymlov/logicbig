package org.krymlov.logicbig.cppnative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.krymlov.logicbig.AbstractTest;

public class NativeCodeTests extends AbstractTest {

    public static final String AAA = "aaa";

    @Test
    void testSum(){
        long sum = CppNativeExecutor.getInstance().sum(1, 2);
        Assertions.assertEquals(3, sum);
    }

    @Test
    void testString(){
        String str = CppNativeExecutor.getInstance().concat(AAA, new StringBuilder());
        Assertions.assertTrue(AAA == str);
    }

    @Test
    void testFactorial(){
        long fact = CppNativeExecutor.getInstance().factorial(5);
        Assertions.assertEquals(5, fact);
    }

}
