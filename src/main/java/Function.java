import java.io.FileWriter;
import java.io.IOException;

public class Function {
    Sin sin = new Sin();
    Logarithms logs = new Logarithms();
    SimpleFunctions simpleFunctions = new SimpleFunctions();
    private String header =
            "x,f(x),sin(x),cos(x),tan(x),cot(x),sec(x),csc(x),log_2(x),log_3(x),log_5(x),log_10(x),ln(x)\n";
    private String filename = "out.csv";
    double eps = 0.00000001;

    public double functionFirst(double x, double eps) {
        return ((Math.pow(simpleFunctions.tan(x, eps) - simpleFunctions.csc(x, eps), 2) / simpleFunctions.csc(x, eps)) + simpleFunctions.cot(x, eps))
                / ((simpleFunctions.sec(x, eps) - simpleFunctions.csc(x, eps)) / (simpleFunctions.sec(x, eps) / simpleFunctions.cos(x, eps)));
    }

    public double functionSecond(double x, double eps) {
        return (((logs.log10(x, eps) + logs.log2(x, eps)) / (logs.log3(x, eps) * logs.log5(x, eps)))
                + (logs.log10(x, eps) / logs.log5(x, eps)) + logs.log5(x, eps))
                - (logs.log2(Math.pow(x, 3), eps));
    }

    public double calculateFunction(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            return Double.NaN;
        double result = 0;
        if (x > 0) {
            result = functionSecond(x, eps);
        } else {
            result = functionFirst(x, eps);
        }
        return result;
    }


}

