package No_201_400.No238除自身以外数组的乘积;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] mul = new int[n];
        int multiple = 1;
        for (int i = 0; i < n; i++) {
            multiple *= nums[i];
            mul[i] = multiple;
        }
        int postMul = 1;
        int[] res = new int[n];
        for (int i = n - 1; i > 0; i--) {
            res[i] = mul[i - 1] * postMul;
            postMul *= nums[i];
        }
        res[0] = postMul;
        return res;
    }
}
