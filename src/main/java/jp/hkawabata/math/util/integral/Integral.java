package jp.hkawabata.math.util.integral;

import jp.hkawabata.math.util.func.Function;

/**
 * 関数の積分を計算するインターフェース
 *
 * Created by kawabatahiroto on 2016/08/26.
 */
interface Integral {

    double dx = 0.1;
    int times = 1000000;

    double calculate(Function function, double x1, double x2);
}
