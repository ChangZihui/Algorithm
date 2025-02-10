package No_1_200.No035搜索插入位置;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 7, 41};
        int i = searchInsert(nums, 6);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private static int search(int[] nums, int l, int r, int target) {
        int i = (l + r) / 2;
        if (nums[i] == target) {
            return i;
        }
        if (l == r) {
            return nums[l] > target ? l : l + 1;
        }

        if (nums[i] > target) {
            return search(nums, l, i, target);
        } else {
            return search(nums, i + 1, r, target);
        }
    }
}
