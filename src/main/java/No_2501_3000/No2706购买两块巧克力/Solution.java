package No_2501_3000.No2706购买两块巧克力;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {90,29,6,74};
        int money = 82;
        System.out.println(buyChoco(prices, money));
    }

    public static int buyChoco(int[] prices, int money) {
        int min1=Math.min(prices[0], prices[1]);
        int min2=Math.max(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < min1) {
                min2 = min1;
                min1 = prices[i];
            } else if (prices[i] < min2) {
                min2 = prices[i];
            }
        }
        if (money>=min1+min2){
            return money-min1-min2;
        }else {
            return money;
        }
    }
}
