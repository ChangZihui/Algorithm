package No_1_200.No122买卖股票的最佳时机II;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int[] profit = new int[prices.length - 1];
        for (int i = 0; i < profit.length; i++) {
            profit[i] = prices[i + 1] - prices[i];
        }
        int maxProfit = 0;
        for (int i = 0; i < profit.length; i++) {
            if (profit[i] > 0) maxProfit += profit[i];
        }
        return maxProfit;
    }
}
