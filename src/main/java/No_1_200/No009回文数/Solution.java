package No_1_200.No009回文数;

public class Solution {
    public static void main(String[] args) {
        int i =0;
        System.out.println(isPalindrome(i));
    }
    public static boolean isPalindrome(int x) {
        int y=x;
        int z=0;
        while (x>0){
            z=z*10+x%10;
            x=x/10;
        }
        return y==z;
    }
}
