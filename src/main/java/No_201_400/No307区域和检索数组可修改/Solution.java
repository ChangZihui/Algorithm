package No_201_400.No307区域和检索数组可修改;

public class Solution {
    public static void main(String[] args) {
        //[0,1,4,9] 0-2,9=3-0/ 1-2,8=3-1/ 0-1,4=2-0
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1,2,5]
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8
    }
}
