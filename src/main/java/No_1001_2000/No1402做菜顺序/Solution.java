package No_1001_2000.No1402做菜顺序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] satisfaction = {4,3,2};
        System.out.println(maxSatisfaction(satisfaction));
    }

    public static int maxSatisfaction(int[] satisfaction) {
        int max = 0;
        Arrays.sort(satisfaction);
        int length = satisfaction.length;
//        for (int i = 1; i <= length; i++) {
//            int sum = 0;
//            for (int j = 1; j <=i; j++) {
//                sum += j * satisfaction[j+length-i-1];
//            }
//            if (max<sum){
//                max=sum;
//            }else {
//                break;
//            }
//        }
        int sum=0;
        for (int i = length-1; i >=0 ; i--) {
            sum+=satisfaction[i];
            if (sum<0){
                break;
            }
            max+=sum;
        }
        return Math.max(max,0);

    }
}