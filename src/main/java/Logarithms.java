public class Logarithms {
    Ln ln = new Ln();



    public  double log2(double x, double eps) {
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
