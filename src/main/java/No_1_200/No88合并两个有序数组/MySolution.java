package No_1_200.No88合并两个有序数组;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
 * 分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
 * nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 官解:
 * @see Solution
 * TODO 思想和官解相同,时间复杂度和空间复杂度也相同,但是没有注意到可以从反方向进行排序,省略初始的移动数组操作
 */
public class MySolution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 如果采用常规的一边遍历一边向后移动数组,那么会导致时间复杂度的增加
     * 考虑到nums1的长度初始即为m+n,可以先将nums1中的元素全部向后移动
     * 在遍历的过程中,从nums1的前端开始添加元素
     * 这样可以在o(m+n)的时间复杂度内完成合并
     * 空间复杂度为o(1)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, m);
            return;
        }
        if (n == 0) {
            return;
        }
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
            nums1[i] = 0;
        }

        int i = n, j = 0;
        while (i + j < m + 2 * n) {
            if (nums1[i] < nums2[j]) {
                nums1[i + j - n] = nums1[i];
                i++;
                if (i >= m + n) break;
            } else {
                nums1[i + j - n] = nums2[j];
                j++;
                if (j == n) break;
            }
        }
        // 如果nums1中的元素已经遍历完,那么需要将nums2中的元素复制过来
        // 如果nums2中的元素已经遍历完,那么由于数组末尾已经是nums1中的元素了,所以不需要操作
        if (j < n) {
            if (n - j >= 0) System.arraycopy(nums2, j, nums1, j + i - n, n - j);
        }
    }
}
