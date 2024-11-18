package No_2001_2500.No2300咒语和药水的成功对数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] spells = {5, 1, 3}, potions = {1,2,3,4,6};
        int success = 7;
        int[] ints = successfulPairs(spells, potions, success);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
//        Arrays.sort(potions);
//        System.out.println(binarySearch(potions, 4));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int potion = (int) Math.ceil((double) success / spell);
            //二分查找
            int index = binarySearch(potions, potion);
            pairs[i] = potions.length - index;
        }
        return pairs;
    }

    private static int binarySearch(int[] a, int key) {
        if (key > a[a.length - 1]) return a.length;
        if (key < a[0]) return 0;
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + (right - left) / 2);
            if (key == a[mid]) {
                while (mid >= 0) {
                    if (a[mid] != key) {
                        break;
                    }
                    mid--;
                }
                if (mid <= -1) {
                    return 0;
                }
                return mid + 1;//多减了一次，返回的时候需要再加1
            } else if (key < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;  // key not found.
    }
}
