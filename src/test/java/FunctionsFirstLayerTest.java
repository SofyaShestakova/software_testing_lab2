import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionsFirstLayerTest {
    double delta = 0.001;
    Sin sin = new Sin();
    Ln ln = new Ln();
    Logarithms log = new Logarithms();

    @Test
    void testSin() {
        assertEquals(0, sin.sin(0, delta));
        assertEquals(-1.000735188111485, sin.sin(3 * PI / 2, delta));
        assertEquals(8.274095221042226E-5, sin.sin(2 * PI, delta));
        assertEquals(0.9998431013994987, sin.sin(PI / 2, delta));
        assertEquals(0.49967417939436376, sin.sin(PI / 6, delta));
        assertEquals(-0.4502095465, sin.sin(-0.467, delta), delta);
        assertEquals(0.2955202067, sin.sin(0.3, delta), delta);
        assertEquals(0.7833269096, sin.sin(0.9, delta), delta);
        assertEquals(0.5, sin.sin(PI / 6, delta), delta);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "sin.csv", delimiter = ';')
    public void csvTest(double expected, double x) {
        double actual = sin(x);
        assertEquals(expected, actual,delta);
    }

    @Test
    void testLn() {
        assertEquals(0.6931347573322881, ln.lnX(2, delta), delta);
        assertEquals(-1.3468559468930204, ln.lnX(0.26, delta));
        assertEquals(-1.347, ln.lnX(0.26, delta), delta);
        assertEquals(-0.288, ln.lnX(0.75, delta), delta);
        assertEquals(0.548, ln.lnX(1.73, delta), delta);
        assertEquals(2.345, ln.lnX(10.45, delta), delta);
        assertEquals(1.3860012904394805, ln.lnX(4, delta), delta);
        assertThrows(NullPointerException.class, () -> ln.lnX(Double.NaN, delta));

    }

}
