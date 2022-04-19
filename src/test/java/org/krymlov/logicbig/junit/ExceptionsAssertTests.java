package org.krymlov.logicbig.junit;

import com.thoughtworks.qdox.model.expression.Divide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.krymlov.logicbig.AbstractTest;
import org.krymlov.logicbig.exception.Divider;
import org.krymlov.logicbig.exception.DividerException;

public class ExceptionsAssertTests extends AbstractTest {

    class CustomException extends Throwable {
    }

    @Test
    void test(){
        Exception exception = Assertions.assertThrows(DividerException.class, () -> Divider.divide(1, 0));
        String expectedMessage = "Divider can not be 0";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void test1() throws CustomException {
        try {
            throw new CustomException();
        } catch (RuntimeException re){
            re.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } catch (Error er){
            er.printStackTrace();
        }
    }

}
