import java.io.FileWriter;
import java.io.IOException;

public class Function {
    private String header =
            "x,f(x),sin(x),cos(x),tan(x),cot(x),sec(x),csc(x),log_2(x),log_3(x),log_5(x),log_10(x),ln(x)\n";
    private String filename = "out.csv";
    double eps = 0.00000001;

    public static double functionFirst(double x, double eps) {
        return ((Math.pow(SimpleFunctions.tan(x, eps) - SimpleFunctions.csc(x, eps), 2) / SimpleFunctions.csc(x, eps)) + SimpleFunctions.cot(x, eps))
                / ((SimpleFunctions.sec(x, eps) - SimpleFunctions.csc(x, eps)) / (SimpleFunctions.sec(x, eps) / SimpleFunctions.cos(x, eps)));
    }

    public static double functionSecond(double x, double eps) {
        return (((SimpleFunctions.log10(x, eps) + SimpleFunctions.log2(x, eps)) / (SimpleFunctions.log3(x, eps) * SimpleFunctions.log5(x, eps)))
                + (SimpleFunctions.log10(x, eps) / SimpleFunctions.log5(x, eps)) + SimpleFunctions.log5(x, eps))
                - (SimpleFunctions.log2(Math.pow(x, 3), eps));
    }

    public Object calculateFunction(double x, double eps) {
        if (x > 0) {
            functionSecond(x, eps);
        } else {
            functionFirst(x, eps);
        }
        return null;
    }

    public void createCSV(double startX, double endX, double step) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        while (startX < endX) {
            fileWriter.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", startX, calculateFunction(startX, eps), SimpleFunctions.sin(startX, eps), SimpleFunctions.cos(startX, eps), SimpleFunctions.tan(startX, eps), SimpleFunctions.cot(startX, eps), SimpleFunctions.sec(startX, eps), SimpleFunctions.csc(startX, eps), SimpleFunctions.log2(startX, eps), SimpleFunctions.log5(startX, eps), SimpleFunctions.log3(startX, eps), SimpleFunctions.log10(startX, eps)));
            startX += step;
        }
        fileWriter.close();
    }

}

