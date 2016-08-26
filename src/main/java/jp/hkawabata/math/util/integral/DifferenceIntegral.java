package jp.hkawabata.math.util.integral;

import jp.hkawabata.math.util.func.Function;

/**
 * 差分法による積分
 *
 * Created by kawabatahiroto on 2016/08/27.
 */
public class DifferenceIntegral implements Integral {

    double dx = 0.001;

    public double calculate(Function function, double x1, double x2) {
        int n = (int)(Math.abs(x2 - x1) / dx);
        double x = x1 + 0.5 * dx;
        double buf = 0;
        for(int i = 0; i < n; i++) {
            buf += function.func(x);
            x += dx;
        }
        return buf * dx;
    }
}
