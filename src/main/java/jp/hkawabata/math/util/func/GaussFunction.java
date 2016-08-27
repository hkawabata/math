package jp.hkawabata.math.util.func;

/**
 * ガウス関数
 *
 * Created by kawabatahiroto on 2016/08/27.
 */
public class GaussFunction implements Function {

    private double sigma;
    private double a;
    private double mu;

    public GaussFunction(double mu, double sigma, double a) {
        this.mu = mu;
        this.sigma = sigma;
        this.a = a;
    }

    public double func(double x) {
        return a * Math.exp(-(x - mu) * (x - mu) / (2 * sigma * sigma) ) / (Math.sqrt(2 * Math.PI) * sigma);
    }
}
