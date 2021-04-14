public class Sin {
    public double sin(double x, double eps) {
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
}
