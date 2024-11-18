package No_201_400.No202快乐数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int temp = 0;
            while (n > 0) {
                int i = n % 10;
                temp += i * i;
                n = n / 10;
            }
            if (set.contains(temp)) {
                return false;
            } else {
                n = temp;
                set.add(n);
            }
        }
        return true;
    }
}
