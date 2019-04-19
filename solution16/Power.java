package solution16;

public class Power {

    public double Power(double base, int exponent) {
        double result = 0.0;
        if (exponent == 0) {
            return 1;
        }
        if (exponent > 0) {
            result = base * Power(base, exponent - 1);
        }
        if (exponent < 0) {
            result = 1 / (base * Power(base, Math.abs(exponent) - 1));
        }
        return result;
    }
}
