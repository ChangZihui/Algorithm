package No_1001_2000.No1969数组元素的最小非零乘积;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(4));
    }


    public static int minNonZeroProduct(int p) {
        long mod = 1000000007L;
        if (p == 1) {
            return 0;
        } else {
            long x = fastPow(2, p, mod) - 1;
            long y = 1L << (p - 1);
            return (int) (fastPow(x - 1, y - 1, mod) * x % mod);
        }
    }


    public static long fastPow(long x, long y, long mod) {
        long res = 1;
        while (y != 0) {
            if ((y & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }
}      e
