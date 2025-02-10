package No_2001_2500.No2469温度转换;

import java.math.BigDecimal;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        double celsius = 36.50;
        Double c = 36.50;
        System.out.println(Arrays.toString(convertTemperature(celsius)));

    }


    public static double[] convertTemperature(double celsius) {
        BigDecimal a = new BigDecimal(celsius);
        BigDecimal b = a.multiply(new BigDecimal("1.80000")).add(new BigDecimal("32.00000"));
        BigDecimal c = a.add(new BigDecimal("273.15000"));
        double[] doubles = new double[2];
        doubles[0] = c.doubleValue();
        doubles[1] = b.doubleValue();
        return doubles;
    }
}
