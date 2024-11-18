package No_201_400.No307区域和检索数组可修改;

public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length + 1];
        this.nums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            this.nums[i] = this.nums[i - 1] + nums[i - 1];
        }
    }


    public void update(int index, int val) {
        int gap = val - (nums[index + 1] - nums[index]);
        for (int i = index + 1; i < nums.length; i++) {
            nums[i] += gap;
        }
    }

    public int sumRange(int left, int right) {
        return nums[right + 1] - nums[left];
    }
}
