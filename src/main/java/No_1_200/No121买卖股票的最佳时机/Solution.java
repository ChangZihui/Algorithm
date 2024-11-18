package No_1_200.No121买卖股票的最佳时机;

public class Solution {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int[] profit = new int[prices.length];
        profit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            profit[i] = Math.max(profit[i - 1] + prices[i] - prices[i - 1], prices[i] - prices[i - 1]);
        }
        int maxProfit = 0;
        for (int j : profit) {
            maxProfit = Math.max(maxProfit, j);
        }
        return maxProfit;
    }
}
