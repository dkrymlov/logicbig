package org.krymlov.logicbig.junit;

import com.thoughtworks.qdox.model.expression.Divide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.krymlov.logicbig.AbstractTest;
import org.krymlov.logicbig.exception.Divider;
import org.krymlov.logicbig.exception.DividerException;

public class ExceptionsAssertTests extends AbstractTest {

    @Test
    void test(){
        Exception exception = Assertions.assertThrows(DividerException.class, () -> Divider.divide(1, 0));
        String expectedMessage = "Divider can not be 0";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
