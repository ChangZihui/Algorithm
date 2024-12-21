package No_2501_3000.No2545根据第K场考试的分数排序;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 4, 2, 6, 1, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 分割
        int split = partition(arr, left, right);
        // 对左边进行排序
        quickSort(arr, left, split - 1);
        // 对右边进行排序
        quickSort(arr, split + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 选择一个基准元素,如最左边
        int base = arr[left];
        // 遍历数组,根据规则进行排序,这里以从小到大进行
        // 所有比base小的元素在左边,比base大的元素在右边
        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if (arr[j] < base) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
