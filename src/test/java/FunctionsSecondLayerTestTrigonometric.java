import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FunctionsSecondLayerTestTrigonometric {
    double delta = 0.001;

    Sin mockSin;
    Ln mockLn;

    SimpleFunctions simpleFunctions;
    SimpleFunctions simpleFunctionsMock;

    @BeforeEach
    void setUp() {
        mockSin = mock(Sin.class);
        mockLn = mock(Ln.class);
        simpleFunctionsMock = mock(SimpleFunctions.class);
        when(mockSin.sin(eq(3.141592653589793), eq(delta))).thenReturn(0.0);
        when(mockSin.sin(eq(3 * PI / 2), eq(delta))).thenReturn(-1.0);
        when(mockSin.sin(eq(PI / 2), eq(delta))).thenReturn(1.0);
        when(mockSin.sin(eq(PI / 6), eq(delta))).thenReturn(0.5);
        when(mockSin.sin(eq(PI / 3), eq(delta))).thenReturn(0.8660254037844386);
        when(mockSin.sin(eq(-PI / 4), eq(delta))).thenReturn(-0.7071067811865475);
        when(mockSin.sin(eq(0.77777), eq(delta))).thenReturn(0.7016923346562092);
        when(mockSin.sin(eq(-0.99995), eq(delta))).thenReturn(-0.8414439686407756);
        when(mockSin.sin(eq(0.246), eq(delta))).thenReturn(0.24352634067370285);
        when(mockSin.sin(eq(0.3777), eq(delta))).thenReturn(0.3687835615501242);


        when(simpleFunctionsMock.cos(eq(1), eq(delta))).thenReturn(1.0);
        when(simpleFunctionsMock.cos(eq(PI/3), eq(delta))).thenReturn(0.5);
        when(simpleFunctionsMock.cos(eq(PI/6), eq(delta))).thenReturn(0.8660254037844387);
        when(simpleFunctionsMock.cos(eq(PI), eq(delta))).thenReturn(-1.0);
        when(simpleFunctionsMock.cos(eq(-PI/8), eq(delta))).thenReturn(0.9238795325112867);
        when(simpleFunctionsMock.cos(eq(-PI/4), eq(delta))).thenReturn(0.7071067811865476);
        when(simpleFunctionsMock.cos(eq(0.77777), eq(delta))).thenReturn(0.7124800821670165);
        when(simpleFunctionsMock.cos(eq(-0.99995), eq(delta))).thenReturn(0.5403443787419847);
        when(simpleFunctionsMock.cos(eq(0.246), eq(delta))).thenReturn(0.9698942836196508);
        when(simpleFunctionsMock.cos(eq(0.3777), eq(delta))).thenReturn(0.9295152955871171);

        when(simpleFunctionsMock.sec(eq(1), eq(delta))).thenReturn(1.0);
        when(simpleFunctionsMock.sec(eq(PI/3), eq(delta))).thenReturn(2.0);
        when(simpleFunctionsMock.sec(eq(PI/6), eq(delta))).thenReturn(1.154);
        when(simpleFunctionsMock.sec(eq(PI), eq(delta))).thenReturn(-1.0);
        when(simpleFunctionsMock.sec(eq(-PI/8), eq(delta))).thenReturn(1.0);
        when(simpleFunctionsMock.sec(eq(-PI/4), eq(delta))).thenReturn(1.0);
        when(simpleFunctionsMock.sec(eq(0.77777), eq(delta))).thenReturn(1.4035480079084994);
        when(simpleFunctionsMock.sec(eq(-0.99995), eq(delta))).thenReturn(1.0);
        when(simpleFunctionsMock.sec(eq(0.246), eq(delta))).thenReturn(1.031040203957069);
        when(simpleFunctionsMock.sec(eq(0.3777), eq(delta))).thenReturn(1.075829526149284);

        when(simpleFunctionsMock.csc (eq(1), eq(delta))).thenReturn(0.0);
        when(simpleFunctionsMock.csc (eq(PI/3), eq(delta))).thenReturn(1.1547);
        when(simpleFunctionsMock.csc (eq(PI/6), eq(delta))).thenReturn(2.0);
        when(simpleFunctionsMock.csc (eq(PI), eq(delta))).thenReturn(0.0);;
        when(simpleFunctionsMock.csc (eq(-PI/4), eq(delta))).thenReturn(-1.4142135623730951);
        when(simpleFunctionsMock.csc (eq(0.77777), eq(delta))).thenReturn(1.425126014081293);
        when(simpleFunctionsMock.csc (eq(-0.99995), eq(delta))).thenReturn(-1.188433261474733);
        when(simpleFunctionsMock.csc (eq(0.246), eq(delta))).thenReturn(4.106331977204406);
        when(simpleFunctionsMock.csc (eq(0.3777), eq(delta))).thenReturn(2.7116176106024246);


        when(simpleFunctionsMock.tan (eq(PI/3), eq(delta))).thenReturn(1.7320508075688767);
        when(simpleFunctionsMock.tan (eq(PI/6), eq(delta))).thenReturn(0.5773502691896258);
        when(simpleFunctionsMock.tan (eq(-PI/4), eq(delta))).thenReturn(-0.7071067811865475);
        when(simpleFunctionsMock.tan (eq(0.77777), eq(delta))).thenReturn(0.9848588784713864);
        when(simpleFunctionsMock.tan (eq(-0.99995), eq(delta))).thenReturn(-0.8414439686407756);
        when(simpleFunctionsMock.tan (eq(0.246), eq(delta))).thenReturn(0.2510854479571332);
        when(simpleFunctionsMock.tan (eq(0.3777), eq(delta))).thenReturn(0.3967482442741155);
        when(simpleFunctionsMock.tan (eq(PI/2), eq(delta))).thenReturn(0.0);
        when(simpleFunctionsMock.tan (eq(3*PI/2), eq(delta))).thenReturn(0.0);





        simpleFunctions = new SimpleFunctions(mockSin, mockLn);
    }

    @Test
    void testCos() {
        assertEquals(0, simpleFunctions.cos(PI / 2, delta), delta);
        assertEquals(-1, simpleFunctions.cos(PI, delta), delta);
        assertEquals(1, simpleFunctions.cos(0, delta), delta);
        assertEquals(0, simpleFunctions.cos(3 * PI / 2, delta), delta);
        assertEquals(1, simpleFunctions.cos(2 * PI, delta), delta);
        assertEquals(0.866, simpleFunctions.cos(PI / 6, delta), delta);
        assertEquals(0.5, simpleFunctions.cos(PI / 3, delta), delta);
    }

    @Test
    void testCsc() {
        assertEquals(-1, simpleFunctions.csc(3 * PI / 2, delta), delta);
        assertThrows(NullPointerException.class, () -> simpleFunctions.csc(PI, delta));
        assertThrows(NullPointerException.class, () -> simpleFunctions.csc(1, delta));
        assertEquals(1, simpleFunctions.csc(PI / 2, delta), delta);
        assertEquals(2, simpleFunctions.csc(PI / 6, delta), delta);
        assertEquals(1.1547, simpleFunctions.csc(PI / 3, delta), delta);
        assertThrows(NullPointerException.class, () -> simpleFunctions.csc(2 * PI, delta));
        assertEquals(-1.4142135623730951, simpleFunctions.csc(-PI / 4, delta), delta);
        assertEquals(1.425126014081293, simpleFunctions.csc(0.77777, delta), delta);
        assertEquals(-1.188433261474733, simpleFunctions.csc(-0.99995, delta), delta);
        assertEquals(4.106331977204406, simpleFunctions.csc(0.246, delta), delta);
        assertEquals(2.7116176106024246, simpleFunctions.csc(0.3777, delta), delta);
    }

    @Test
    void testSec(){
        assertEquals(1, simpleFunctions.sec(1, delta), delta);
        assertEquals(2, simpleFunctions.sec(PI/3, delta), delta);
        assertEquals(1.154, simpleFunctions.sec(PI/6, delta), delta);
        assertEquals(-1, simpleFunctions.sec(PI, delta), delta);
        assertEquals(1, simpleFunctions.sec(-PI/8, delta), delta);
        assertEquals(1, simpleFunctions.sec(-PI/4, delta), delta);
        assertEquals(1.4035480079084994, simpleFunctions.sec(0.77777, delta), delta);
        assertEquals(1, simpleFunctions.sec(-0.99995, delta), delta);
        assertEquals(1.031040203957069, simpleFunctions.sec(0.246, delta), delta);
        assertEquals(1.075829526149284, simpleFunctions.sec(0.3777, delta), delta);
        assertThrows(NullPointerException.class, () -> simpleFunctions.sec(PI/2, delta));
        assertThrows(NullPointerException.class, () -> simpleFunctions.sec(3*PI/2, delta));
    }

    @Test
    void testTan(){
        assertEquals(1.7320508075688767, simpleFunctions.tan(PI/3, delta), delta);
        assertEquals(0.5773502691896258, simpleFunctions.tan(PI/6, delta), delta);
        assertEquals(-0.7071067811865475, simpleFunctions.tan(-PI/4, delta), delta);
        assertEquals(0.9848588784713864, simpleFunctions.tan(0.77777, delta), delta);
        assertEquals(-0.8414439686407756, simpleFunctions.tan(-0.99995, delta), delta);
        assertEquals(0.2510854479571332, simpleFunctions.tan(0.246, delta), delta);
        assertEquals(0.3967482442741155, simpleFunctions.tan(0.3777, delta), delta);
        assertThrows(NullPointerException.class, () -> simpleFunctions.tan(PI/2, delta));
        assertThrows(NullPointerException.class, () -> simpleFunctions.tan(3*PI/2, delta));
    }

    @Test
    void testCot(){
        assertEquals(0.577350269189626, simpleFunctions.cot(PI/3, delta), delta);
        assertEquals(1.732050807568877, simpleFunctions.cot(PI/6, delta), delta);
        assertEquals(-1.4142135623730951, simpleFunctions.cot(-PI/4, delta), delta);
        assertEquals(1.0153738996109922, simpleFunctions.cot(0.77777, delta), delta);
        assertEquals(-1.188433261474733, simpleFunctions.cot(-0.99995, delta), delta);
        assertEquals(3.982707911335132, simpleFunctions.cot(0.246, delta), delta);
        assertEquals(2.520490044838345, simpleFunctions.cot(0.3777, delta), delta);
        assertThrows(NullPointerException.class, () -> simpleFunctions.cot(PI/2, delta));
        assertThrows(NullPointerException.class, () -> simpleFunctions.cot(3*PI/2, delta));
    }




}


