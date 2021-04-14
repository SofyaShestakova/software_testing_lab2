public class Ln {
    public  double lnX(double x, double eps){
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
}
