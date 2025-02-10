package No_1_200.No066加一;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums={1,2,9};
        int[] result=plusOne(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] plusOne(int[] digits) {
        int ad=1;
        for (int i = digits.length-1; i >=0; i--) {
            int j=digits[i]+ad;
            digits[i]=j%10;
            ad=j/10;
        }
        if (ad==1){
            int[] result=new int[digits.length+1];
            result[0]=1;
            for (int i = 1; i < digits.length + 1; i++) {
                result[i]=digits[i-1];
            }
            return result;
        }
        return digits;
    }
}
