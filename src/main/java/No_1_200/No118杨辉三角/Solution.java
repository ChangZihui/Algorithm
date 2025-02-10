package No_1_200.No118杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int i = 10;
        List<List<Integer>> generate = generate(i);
        for (List<Integer> integers : generate) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> integerList = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    integerList.add(1);
                } else {
                    integerList.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }
            }
            list.add(integerList);
        }
        return list;
    }

}
