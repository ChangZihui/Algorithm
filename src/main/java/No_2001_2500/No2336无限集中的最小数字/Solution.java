package No_2001_2500.No2336无限集中的最小数字;

public class Solution {
    public static void main(String[] args) {
        SmallestInfiniteSet list = new SmallestInfiniteSet();
        list.addBack(2);
        System.out.println(list.popSmallest());
        System.out.println(list.popSmallest());
        System.out.println(list.popSmallest());
        list.addBack(1);
        System.out.println(list.popSmallest());
        System.out.println(list.popSmallest());
        System.out.println(list.popSmallest());
    }
}
