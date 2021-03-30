
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;


public class FunctionsFourthLayerTest {
    double delta = 0.001;


    /* Положительная часть функции(functionSecond) по графику из вольфрама от 0 до 0,360536 убывает,
    также убывает на промежутке от 1 до 3.09689, все исключая. Точки экстремума - 0.360536 и
    3.09689. Значение функции не определено при x = 1
    */
    @Mock
    double functionSecondMock = Function.functionSecond(0, 0.001);
    double functionSecondMock1 = Function.functionSecond(0.360536, 0.00001);
    double functionSecondMock2 = Function.functionSecond(3.09689, 0.001);
    double functionSecondMock3 = Function.functionSecond(1, 0.001);
    double functionSecondMock4 = Function.functionSecond(0.01, 1E-16);
    double functionSecondMock5 = Function.functionSecond(2, 0.001);
    double functionSecondMock6 = Function.functionSecond(1.97, 0.001);
    double functionSecondMock7 = Function.functionSecond(1.15, 0.001);
    double functionSecondMock8 = Function.functionSecond(2.15, 0.001);


    @Test
    void testCorrectValue() {
        assertEquals(17.0485,functionSecondMock4,delta);
    }
    @Test
    void testCorrectValue1() {
        assertEquals(2.918,functionSecondMock5,delta);
    }
    @Test
    void testCorrectValue2() {
        assertEquals(3.080,functionSecondMock6,delta);
    }


}
