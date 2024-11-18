package No_1001_2000.No1954收集足够苹果的最小花园周长;

public class Solution {
    public static void main(String[] args) {
        long neededApples = 215073301725407L;
        System.out.println(minimumPerimeter(neededApples));
    }

    public static long minimumPerimeter(long neededApples) {
        long n = 1;
        while ( 2 * n * (n + 1) * (2 * n + 1) < neededApples) {
            n ++;
        }
        return 8 * n;
    }

}
