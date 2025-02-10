package No_1_200.No069x的平方根;

public class Solution {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x==1){
            return 1;
        }
        long y = x;
        long z = 0;
        while (z <= y) {
            if (z *z <= x && (z + 1) * (z + 1) > x) {
                return (int)z;
            }
            long i = (z + y) / 2;
            if (i * i > x) {
                y = i;
            } else {
                z = i;
            }
        }
        return 0;
    }
}
