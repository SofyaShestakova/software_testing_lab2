import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsFirstLayerTest {
    double delta = 0.001;
    @Mock
    double sinZeroMock = SimpleFunctions.sin(0, 0.001);
    double sinPI6Mock = SimpleFunctions.sin(PI / 6, 0.001);
    double sinNegativeMock = SimpleFunctions.sin(-3 * PI / 2, 0.001);
    double sinNegativeMock2 = SimpleFunctions.sin(-PI / 4, 0.001);
    double sinNegativeMock3 = SimpleFunctions.sin(5 * PI / 4, 0.001);
    double sinPI2Mock = SimpleFunctions.sin(PI / 2, 0.001);
    double sinMinMock = SimpleFunctions.sin(-PI / 2, 0.001);

    @Mock
    double lnMock = SimpleFunctions.lnX(0,0.001);



    @Test
    void testSinZeroValue() {
        assertEquals(Math.sin(0), sinZeroMock, delta);
    }

    @Test
    void testSinPi6Value() {
        assertEquals(Math.sin(PI / 6), sinPI6Mock, delta);
    }

    @Test
    void testSinNegativeValue() {
        assertEquals(Math.sin(-3 * PI / 2), sinNegativeMock, delta);
    }

    @Test
    void testSinNegativeValue2() {
        assertEquals(Math.sin(-PI / 4), sinNegativeMock2, delta);
    }

    @Test
    void testSinLeftCorner() {
        assertEquals(Math.sin(5 * PI / 4), sinNegativeMock3, delta);
    }

    @Test
    void testMaxValue() {
        assertEquals(Math.sin(PI / 2), sinPI2Mock, delta);
    }

    @Test
    void testMinValue() {
        assertEquals(Math.sin(-PI / 2), sinMinMock, delta);
    }

}
