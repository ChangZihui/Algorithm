package No_1001_2000.No825适龄的朋友;

import java.util.Arrays;

public class MySolution {

    //825. 适龄的朋友

    //在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
    //
    //如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
    //
    //ages[y] <= 0.5 * ages[x] + 7
    //ages[y] > ages[x]
    //ages[y] > 100 && ages[x] < 100
    //否则，x 将会向 y 发送一条好友请求。
    //
    //注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
    //
    //返回在该社交媒体网站上产生的好友请求总数。

    // 官解:双指针
    public static void main(String[] args) {
        int[] ages = {49, 110, 13, 39, 45, 104, 9, 114, 86, 72, 13, 24, 10, 77, 103, 85, 9, 21, 66, 25};
//        int[] ages = {16 ,16};
        System.out.println(numFriendRequests(ages));
//        System.out.println(binarySearch(ages,57));
    }


    public static int numFriendRequests(int[] ages) {
        int length = ages.length;
        Arrays.sort(ages);
        if (length == 0 || length == 1) {
            return 0;
        }
        // 前i个元素产生的好友请求
        // dp[i+1]=dp[i]+增加一个元素新产生的请求数
        // 如果新增加的元素与之前数组的最后一个元素相等,则需要判断有多少个相等的元素来决定增加的数量
        // 如果新增加的元素与之前的数据最后一个元素不相等,则需要重新计算ages[i]/2+7的位置来决定请求增加的数量
        // 可以使用数组最后一个元素来存储ages末尾元素的个数
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[length] = 1;
        for (int i = 1; i < length; i++) {
            int delta;
            int min = ages[i] / 2 + 7;
            int index = binarySearch(ages, min);
            int j = index >= i ? 0 : i - index;
            if (ages[i] == ages[i - 1]) {
                delta = j + (ages[i] > 14 ? dp[length] : 0);
                dp[length]++;
            } else {
                delta = j;
                dp[length] = 1;
            }
            dp[i] = dp[i - 1] + delta;
        }
        return dp[length - 1];
    }

    private static int binarySearch(int[] ages, int min) {
        int start = 0;
        int end = ages.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (ages[mid] <= min) {
                start = mid + 1;
            } else if (ages[mid] > min) {
                end = mid - 1;
            }
        }
        return start;
    }


}
