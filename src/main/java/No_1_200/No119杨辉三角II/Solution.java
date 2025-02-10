package No_1_200.No119杨辉三角II;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int i = 34;
        System.out.println(getRow(i));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            integerList.add((mul(rowIndex).divide(mul(i)).divide(mul(rowIndex - i))).intValue());
        }

        return integerList;
    }

    public static BigDecimal mul(int i) {
        BigDecimal r = new BigDecimal("1");
        for (; i > 0; i--) {
            r = r.multiply(new BigDecimal(i + ""));
        }
        return r;
    }
}
