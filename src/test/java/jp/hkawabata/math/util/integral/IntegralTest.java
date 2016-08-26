package jp.hkawabata.math.util.integral;

import static junit.framework.Assert.*;

import jp.hkawabata.math.util.func.NOrderFunction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 積分のテスト
 *
 * Created by kawabatahiroto on 2016/08/26.
 */
public class IntegralTest {

    double delta = 0.1;
    private List<Integral> integrals = new ArrayList<>();

    @Before
    public void before() {
        integrals.add(new MonteCarloIntegral());
        integrals.add(new DifferenceIntegral());
    }

    @Test
    public void testLinearFunc() {
        int n = 1;
        double indices[] = {2, 1};
        NOrderFunction function = new NOrderFunction(n, indices);

        for (Integral integral: integrals) {
            double result = integral.calculate(function, 0, 3);
            System.out.println(result);
            assertEquals(12, result, delta);
        }
    }

    @Test
    public void testQuadraticFunc() {
        int n = 2;
        double indices[] = {3, 2, 1};
        NOrderFunction function = new NOrderFunction(n, indices);

        for (Integral integral: integrals) {
            double result = integral.calculate(function, 0, 3);
            System.out.println(result);
            assertEquals(39, result, delta);
        }
    }
}
