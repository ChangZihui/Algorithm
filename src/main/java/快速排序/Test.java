package 快速排序;

import java.util.Arrays;
import java.util.Scanner;

class Test {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = nums[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && nums[i] < x) {
                i++;
            }
            while (i < j && nums[j] > x) {
                j--;
            }
            if (i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++;
        }
        quickSort(nums, l, i - 1);
        quickSort(nums, i , r);
    }
}
