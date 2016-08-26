package jp.hkawabata.math.util.func;

/**
 * N次関数
 *
 * Created by kawabatahiroto on 2016/08/26.
 */
public class NOrderFunction implements Function {

    private int n;
    private double indices[];

    public NOrderFunction(int n, double indices[]) {
        if (indices.length != n + 1) {
            throw new IllegalArgumentException(String.format(
                    "%d-order function needs just %d indices, but actual it has %d.", n, n + 1, indices.length));
        }
        this.n = n;
        this.indices = indices;
    }

    public double func(double x) {
        double res = 0;
        for (int i = 0; i <= n; i++) {
            res += indices[i] * Math.pow(x, n - i);
        }
        return res;
    }
}
