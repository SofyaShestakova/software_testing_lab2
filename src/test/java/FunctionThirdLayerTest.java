import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FunctionThirdLayerTest {
    double delta = 0.001;
    Function function = new Function();
    Ln lnMock = new Ln();
    Sin mockSin = new Sin();
    Logarithms logMock = new Logarithms();
    SimpleFunctions simpleFunctionsMock = new SimpleFunctions();
    @BeforeEach
    void setUp() {

        simpleFunctionsMock = mock(SimpleFunctions.class);
        logMock = mock(Logarithms.class);
        lnMock = mock(Ln.class);
        mockSin = mock(Sin.class);


        when(mockSin.sin(eq(PI / 6), eq(delta))).thenReturn(0.5);
        when(simpleFunctionsMock.cos(eq(PI / 6), eq(delta))).thenReturn(0.8660254037844387);
        when(simpleFunctionsMock.csc(eq(PI / 6), eq(delta))).thenReturn(2.0);
        when(simpleFunctionsMock.sec(eq(PI / 6), eq(delta))).thenReturn(1.154);
        when(simpleFunctionsMock.tan(eq(PI / 6), eq(delta))).thenReturn(0.5773502691896258);
        when(simpleFunctionsMock.cot(eq(PI / 6), eq(delta))).thenReturn(1.732050807568877);
        when(lnMock.lnX(eq(PI / 6), eq(delta))).thenReturn(-0.647022680548835);
        when(logMock.log2(eq(PI / 6), eq(delta))).thenReturn(-0.9334731431432935);
        when(logMock.log5(eq(PI / 6), eq(delta))).thenReturn(-0.4021436317192642);
        when(logMock.log3(eq(PI / 6), eq(delta))).thenReturn(-0.5890058923208524);
        when(logMock.log10(eq(PI / 6), eq(delta))).thenReturn(-0.28117081699988733);

        when(mockSin.sin(eq(0.77777), eq(delta))).thenReturn(0.7016923346562092);
        when(simpleFunctionsMock.cos(eq(0.77777), eq(delta))).thenReturn(0.7124800821670165);
        when(simpleFunctionsMock.csc (eq(0.77777), eq(delta))).thenReturn(1.425126014081293);
        when(simpleFunctionsMock.sec(eq(0.77777), eq(delta))).thenReturn(1.4035480079084994);
        when(simpleFunctionsMock.tan (eq(0.77777), eq(delta))).thenReturn(0.9848588784713864);
        when(simpleFunctionsMock.cot (eq(0.77777), eq(delta))).thenReturn(1.0153738996109922);
        when(lnMock.lnX(eq(0.77777), eq(delta))).thenReturn(-0.25132429037643206);
        when(logMock.log2(eq(0.77777), eq(delta))).thenReturn(-0.3625908060702653);
        when(logMock.log5(eq(0.77777), eq(delta))).thenReturn(-0.15620544056587676);
        when(logMock.log3(eq(0.77777), eq(delta))).thenReturn(-0.22878871539635692);
        when(logMock.log10(eq(0.77777), eq(delta))).thenReturn(-0.10921573258779259);

        when(mockSin.sin(eq(-0.99995), eq(delta))).thenReturn(-0.8414439686407756);
        when(simpleFunctionsMock.cos(eq(-0.99995), eq(delta))).thenReturn(0.5403443787419847);
        when(simpleFunctionsMock.sec(eq(-0.99995), eq(delta))).thenReturn(1.0);
        when(simpleFunctionsMock.csc (eq(-0.99995), eq(delta))).thenReturn(-1.188433261474733);
        when(simpleFunctionsMock.tan (eq(-0.99995), eq(delta))).thenReturn(-0.8414439686407756);
        when(simpleFunctionsMock.cot (eq(-0.99995), eq(delta))).thenReturn(-1.188433261474733);
        when(lnMock.lnX(eq(-0.99995), eq(delta))).thenReturn(0.0);
        when(logMock.log2(eq(-0.99995), eq(delta))).thenReturn(0.0);
        when(logMock.log5(eq(-0.99995), eq(delta))).thenReturn(0.0);
        when(logMock.log3(eq(-0.99995), eq(delta))).thenReturn(0.0);
        when(logMock.log10(eq(-0.99995), eq(delta))).thenReturn(0.0);





    }
    @Test
    void testPi6Value(){
        assertEquals(-2.0317963148611673,function.calculateFunction(PI/6,delta));
    }
    @Test
    void testPositiveValue(){
        assertEquals(-11.5710903956711,function.calculateFunction(0.77777,delta));
        assertEquals(-11.5710903956711,function.functionSecond(0.77777,delta));
    }

    @Test
    void testNegativeValue(){
        assertThrows(NullPointerException.class, () -> function.calculateFunction(-0.99995,delta));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "calculateFunction.csv", delimiter = ';')
    public void csvTest(double expected, double x) {
        double actual = function.calculateFunction(x,delta);
        assertEquals(expected, actual,delta);
    }
}
