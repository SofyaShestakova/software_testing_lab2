import static java.lang.Math.PI;

public class SimpleFunctions {

    public static double sin(double x, double eps) {
        double sum = 0;
        double preSum = x;
        int i = 1;
        while (Math.abs(preSum) > eps) {
            sum += preSum;
            preSum *= -x * x / (2 * i * (2 * i + 1));
            i++;
        }
        return sum;
    }

    public static double cos(double x, double eps) {
        double sign;
        if (((x % (2.0 * PI)) < -1.5 * PI) || ((x % (2.0 * PI)) > 1.5 * PI) ||
                ((x % (2.0 * PI)) < PI / 2) && ((x % (2.0 * PI)) > -PI / 2))
            sign = 1;
        else
            sign = -1;
        return sin(x + PI / 2, eps);
    }

    public static double lnX(double x, double eps){
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new NullPointerException();
        if (x == 1) return 0;
        double z = (x - 1) / (x + 1);
        double preSum = 0;
        double sum = 2 * z;
        int i = 1;
        while (Math.abs(-preSum + sum) > eps) {
            preSum = sum;
            sum += 2 * Math.pow(z
                    , 2 * i + 1) / (2 * i + 1);
            i++;
        }
        return sum;

    }

    public static double sec(double x, double eps) {
        return 1 / cos(x, eps);
    }

    public static double tan(double x, double eps) {
        return sin(x, eps) / cos(x, eps);
    }

    public static double cot(double x, double eps) {
        return cos(x, eps) / sin(x, eps);
    }

    public static double csc(double x, double eps) {
        return 1 / sin(x, eps);
    }

    public static double log2(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new NullPointerException();
        return lnX(x, eps) / lnX(2, eps);
    }

    public static double log3(double x, double eps) {
        return lnX(x, eps) / lnX(3, eps);
    }

    public static double log10(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new NullPointerException();
        return lnX(x, eps) / lnX(10, eps);
    }

    public static double log5(double x, double eps) {
        return lnX(x, eps) / lnX(5, eps);
    }

}

