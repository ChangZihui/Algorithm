package No_2501_3000.No2525根据规则将箱子分类;

public class Solution {
    public static void main(String[] args) {
        int length = 1000, width = 35, height = 700, mass = 300;
        System.out.println(categorizeBox(length, width, height, mass));
    }

    public static String categorizeBox(int length, int width, int height, int mass) {
        int i=0, j=0;
        if (length >= 10000 || width >= 10000 || height >= 10000) i = 1;
        if ((long) length * width * height >= 1000000000) i = 1;
        if (mass >= 100) j = 1;
        if (i+j==0) return "Neither";
        if (i+j==2) return "Both";
        if (i==1&&j==0) return "Bulky";
        if (i==0&&j==1) return "Heavy";
        return "";
    }

}
