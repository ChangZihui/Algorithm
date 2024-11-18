package No_1_200.No167两数之和II输入有序数组;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {-1,0}  ;
        int target = -1;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
                continue;
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
                continue;
            }
            return new int[]{i+1, j+1};
        }
        return null;
    }
}
