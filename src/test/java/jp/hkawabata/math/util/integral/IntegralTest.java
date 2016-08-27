package jp.hkawabata.math.util.integral;

import static junit.framework.Assert.*;

import jp.hkawabata.math.util.func.NOrderFunction;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 * 積分のテスト
 *
 * Created by kawabatahiroto on 2016/08/26.
 */
public class IntegralTest {

    //Logger logger = Logger.getLogger(getClass().getName());
    Logger logger = Logger.getLogger(getClass().getName());

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

        logger.info(String.format("f(x) = %.2f x + %.2f", indices[0], indices[1]));
        for (Integral integral: integrals) {
            double result = integral.calculate(function, 0, 3);
            logger.info(String.format("\t%s: %f", integral.getClass().getSimpleName(), result));
            assertEquals(12, result, delta);
        }
    }

    @Test
    public void testQuadraticFunc() {
        int n = 2;
        double indices[] = {3, 2, 1};
        NOrderFunction function = new NOrderFunction(n, indices);

        logger.info(String.format("f(x) = %.2f x^2 + %.2f x + %.2f", indices[0], indices[1], indices[2]));
        for (Integral integral: integrals) {
            double result = integral.calculate(function, 0, 3);
            logger.info(String.format("\t%s: %f", integral.getClass().getSimpleName(), result));
            assertEquals(39, result, delta);
        }
    }
}
