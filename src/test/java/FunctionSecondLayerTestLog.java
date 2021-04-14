import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FunctionSecondLayerTestLog {
    double delta = 0.001;
    Ln mockLn = new Ln();

    Logarithms log = new Logarithms();
    Logarithms logMock;

    @BeforeEach
    void setUp() {
        mockLn = mock(Ln.class);
        logMock = mock(Logarithms.class);


        when(mockLn.lnX(eq(2), eq(delta))).thenReturn(0.6931347573322881);
        when(mockLn.lnX(eq(4), eq(delta))).thenReturn(1.3860012904394805);
        when(mockLn.lnX(eq(0), eq(delta))).thenReturn(-8.872264846920087);
        when(mockLn.lnX(eq(0.255), eq(delta))).thenReturn(-1.36623913071725);
        when(mockLn.lnX(eq(8), eq(delta))).thenReturn(2.078344410930892);
        when(mockLn.lnX(eq(17), eq(delta))).thenReturn(2.830394243832383);
        when(mockLn.lnX(eq(3), eq(delta))).thenReturn(1.0984995039682537);
        when(mockLn.lnX(eq(5), eq(delta))).thenReturn(1.6089342949001875);
        when(mockLn.lnX(eq(10), eq(delta))).thenReturn(2.3011729576085216);


    }

    @Test
    void testLog2() {
        assertEquals(1, log.log2(-0.99995, delta), delta);
        assertEquals(2, log.log2(4, delta), delta);
        assertEquals(-12.800201913214305, log.log2(0, delta), delta);
        assertEquals(-1.971101746470746, log.log2(0.255, delta), delta);
        assertEquals(2.9984709162904317, log.log2(8, delta), delta);
        assertEquals(4.083468927061025, log.log2(17, delta), delta);
        assertEquals(1.584828191557034, log.log2(3, delta), delta);
        assertEquals(2.3212431318443696, log.log2(5, delta), delta);
        assertEquals(3.3199503174032023, log.log2(10, delta), delta);
    }

    @Test
    void testLog3(){
        assertEquals(0.6309832228675449, log.log3(2, delta), delta);
        assertEquals(1.261722272456789, log.log3(4, delta), delta);
        assertEquals(-8.076712656555276, log.log3(0, delta), delta);
        assertEquals(-1.2437321325879578, log.log3(0.255, delta), delta);
        assertEquals(1.891984842435537, log.log3(8, delta), delta);
        assertEquals(2.5766003840764413, log.log3(17, delta), delta);
        assertEquals(1, log.log3(3, delta), delta);
        assertEquals(1.4646654723903136, log.log3(5, delta), delta);
        assertEquals(2.094832951035201, log.log3(10, delta), delta);
        assertEquals(2, log.log3(9, delta), delta);
    }

    @Test
    void testLog5(){
        assertEquals(0.4308036440824874, log.log5(2, delta), delta);
        assertEquals(0.8614405789177756, log.log5(4, delta), delta);
        assertEquals(-5.514373629204349, log.log5(0, delta), delta);
        assertEquals(-0.8491578152369526, log.log5(0.255, delta), delta);
        assertEquals(1.2917521974132729, log.log5(8, delta), delta);
        assertEquals(1.7591732942754945, log.log5(17, delta), delta);
        assertEquals(0.6827497601674285, log.log5(3, delta), delta);
        assertEquals(1, log.log5(5, delta), delta);
        assertEquals(1.43024669491011, log.log5(10, delta), delta);
        assertEquals(1.364854872891428, log.log5(9, delta), delta);
    }

    @Test
    void testLog10(){
        assertEquals(0.3012093267655221, log.log10(2, delta), delta);
        assertEquals(0.6023020937460837, log.log10(4, delta), delta);
        assertEquals(-3.8555402007420287, log.log10(0, delta), delta);
        assertEquals(-0.5937142300407983, log.log10(0.255, delta), delta);
        assertEquals(0.9031674060218391, log.log10(8, delta), delta);
        assertEquals(1.2299789263879803, log.log10(17, delta), delta);
        assertEquals(0.4773650326179141, log.log10(3, delta), delta);
        assertEquals(0.6991800810019345, log.log10(5, delta), delta);
        assertEquals(1, log.log10(10, delta), delta);
        assertEquals(0.9542793405841138, log.log10(9, delta), delta);
    }


}
