package jp.hkawabata.math.util.integral;

import java.util.Random;
import jp.hkawabata.math.util.func.Function;

/**
 * モンテカルロ積分
 *
 * Created by kawabatahiroto on 2016/08/27.
 */
public class MonteCarloIntegral implements Integral {

    double dx = 0.1;
    int times = 1000000;
    Random random = new Random();

    public double calculate(Function function, double x1, double x2) {
        TopBottom topBottom = getTopBottom(function, x1, x2);
        double top = topBottom.getTop();
        double bottom = topBottom.getBottom();

        int cnt = 0;
        for (int i = 0; i < times; i++) {
            double xRand = getRandomDouble(x1, x2);
            double yRand = getRandomDouble(bottom, top);
            double y = function.func(xRand);
            if (0 < yRand && yRand < y) {
                cnt++;
            } else if (y < yRand && yRand < 0) {
                cnt--;
            }
        }
        return Math.abs(x2 - x1) * (top - bottom) * (double)cnt / times;
    }

    private TopBottom getTopBottom(Function function, double x1, double x2) {
        if (x1 <= x2) {
            double max = function.func(x1);
            double min = function.func(x1);
            int n = (int)((x2 - x1) / dx);
            for (int i = 1; i <= n; i++) {
                double x = x1 + dx * i;
                double y = function.func(x);
                if (max < y) max = y;
                if (y < min) min = y;
            }

            double top;
            double bottom;
            if (max < 0) { top = 0; } else { top = max; }
            if (0 < min) { bottom = 0; } else { bottom = min; }
            return new TopBottom(top, bottom);

        } else {
            return getTopBottom(function, x2, x1);
        }
    }

    private class TopBottom {
        private double top;
        private double bottom;
        private TopBottom(double top, double bottom) {
            this.top = top;
            this.bottom = bottom;
        }
        public double getTop() { return top; }
        public double getBottom() { return bottom; }
    }

    private double getRandomDouble(double v1, double v2) {
        return v1 + (v2 - v1) * random.nextDouble();
    }
}
