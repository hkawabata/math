package jp.hkawabata.math.util.integral;

import static junit.framework.Assert.*;

import jp.hkawabata.math.util.func.NOrderFunction;
import org.junit.Before;
import org.junit.Test;

/**
 * モンテカルロ積分のテスト
 *
 * Created by kawabatahiroto on 2016/08/26.
 */
public class MonteCarloIntegralTest {

    private Integral integral;

    @Before
    public void before() {
        integral = new MonteCarloIntegral();
    }

    @Test
    public void testLinearFunc() {
        int n = 1;
        double indices[] = {2, 1};
        NOrderFunction func = new NOrderFunction(n, indices);
        double result = integral.calculate(func, 0, 3);
        System.out.println(result);
        assertEquals(12, result, 0.1);
    }

    @Test
    public void testQuadraticFunc() {
        int n = 2;
        double indices[] = {3, 2, 1};
        NOrderFunction func = new NOrderFunction(n, indices);
        double result = integral.calculate(func, 0, 3);
        System.out.println(result);
        assertEquals(39, result, 0.1);
    }
}
