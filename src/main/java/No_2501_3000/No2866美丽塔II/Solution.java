package No_2501_3000.No2866美丽塔II;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> maxHeights = Arrays.asList(5,3,4,1,1);
        System.out.println(maximumSumOfHeights(maxHeights));
    }

    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        long max = 0;
        int n = maxHeights.size();
        long[] incr = new long[n];
        long[] desc = new long[n];
        long pre=maxHeights.get(0);
        long pst=maxHeights.get(n-1);

        for (int i = 0; i < n; i++) {
            pre = Math.min(pre, maxHeights.get(i));
            pst = Math.min(maxHeights.get(n-1-i), pst);
            desc[i]=pre;
            incr[n-1-i]=pst;
        }
        long[] sumincr=new long[n+1];
        long[] sumdesc=new long[n+1];
        long sum1=0;
        long sum2=0;
        for (int i = 0; i < n; i++) {
            sum1+=incr[i];
            sum2+=desc[n-1-i];
            sumincr[i+1]=sum1;
            sumdesc[n-i-1]=sum2;
        }
        for (int i = 0; i < n; i++) {
            long maxi = sumincr[i]+sumdesc[i]-maxHeights.get(i);
            max = Math.max(max, maxi);
        }
        return max;
    }

//    public static long maximumSumOfHeights(List<Integer> maxHeights) {
//        long max = 0;
//        int n = maxHeights.size();
//        for (int i = 0; i < n; i++) {
//            long maxi=0;
//            long pre=maxHeights.get(i);
//            for (int j = i; j <n; j++) {
//                pre=Math.min(pre,maxHeights.get(j));
//                maxi+=pre;
//            }
//            pre=maxHeights.get(i);
//            for (int j = i-1; j >=0; j--) {
//                pre=Math.min(maxHeights.get(j),pre);
//                maxi+=pre;
//            }
//            max=Math.max(max,maxi);
//        }
//        return max;
//    }

}
