package org.krymlov.logicbig.junit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.krymlov.logicbig.AbstractTest;

class BasicJunitTests extends AbstractTest {

    @Order(2)
    @RepeatedTest(5)
    void test(RepetitionInfo info) {
        System.out.println(Thread.currentThread().getName());
    }

    @Order(1)
    @ParameterizedTest()
    @EnumSource(ParamEnum.class)
    void testHouseSystem(ParamEnum paramEnum) {
        System.out.println(paramEnum.name());
    }

    enum ParamEnum {
        first, second, third
    }
}
