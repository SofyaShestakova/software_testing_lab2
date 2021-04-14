import static java.lang.Math.PI;

public class SimpleFunctions {
    Sin sin;
    Ln ln;

    public SimpleFunctions(Sin sin, Ln ln) {
        this.sin = sin;
        this.ln = ln;
    }

    public SimpleFunctions() {

    }


    public double cos(double x, double eps) {
        double result = 0;
        if (x < 0) x = -x;
        while (x >= PI) {
            x -= 2 * PI;
        }
        if (x < 0) x = -x;
        result = Math.sqrt(1 - Math.pow(sin.sin(x, eps), 2));
        if (x >= 0 && x <= PI / 2) return result;
        else return -result;
    }


    public double sec(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x) || cos(x, eps) == 0)
            throw new NullPointerException();
        return 1 / cos(x, eps);
    }

    public double tan(double x, double eps) {
        return sec(x, eps) / csc(x, eps);
    }

    public double cot(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x) || tan(x, eps) == 0)
            throw new NullPointerException();
        return 1 / tan(x,eps);
    }

    public double csc(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x) || sin.sin(x, eps) == 0)
        throw new NullPointerException();
        return 1 / (sin.sin(x, eps));
    }

    public  double log2(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new NullPointerException();
        return ln.lnX(x, eps) / ln.lnX(2, eps);
    }

    public  double log3(double x, double eps) {
        return ln.lnX(x, eps) / ln.lnX(3, eps);
    }

    public  double log10(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new NullPointerException();
        return ln.lnX(x, eps) / ln.lnX(10, eps);
    }

    public  double log5(double x, double eps) {
        return ln.lnX(x, eps) / ln.lnX(5, eps);
    }

}

