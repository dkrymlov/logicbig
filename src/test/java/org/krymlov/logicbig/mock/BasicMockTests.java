package org.krymlov.logicbig.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.krymlov.logicbig.AbstractTest;
import org.krymlov.logicbig.api.ISomething;
import org.mockito.Mockito;

class BasicMockTests extends AbstractTest {

    @Test
    void mockSomething() {
        ISomething something = Mockito.mock(ISomething.class);
        int i = something.doSomething();
        Assertions.assertEquals(i, 0);
    }

}
