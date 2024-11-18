package No_1001_2000.No1276不浪费原料的汉堡制作方案;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int tomatoSlices = 2, cheeseSlices = 1;
        List<Integer> list = numOfBurgers(tomatoSlices, cheeseSlices);
        System.out.println(Arrays.toString(list.toArray()));

    }

    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        if (tomatoSlices % 2 != 0) {
            return list;
        }
        int start = 0, end = cheeseSlices;
        while (start <= end) {
            int i = (start + end) / 2;
            int gap = (i) * 4 + (cheeseSlices - i) * 2 - tomatoSlices;
            if (gap == 0) {
                list.add(i);
                list.add(cheeseSlices - i);
                break;
            } else if (gap < 0) {
                start = i+1;
            } else {
                end = i-1;
            }
        }
        return list;

    }
}
