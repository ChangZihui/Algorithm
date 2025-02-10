package No_1_200.No067二进制求和;

public class Solution {
    public static void main(String[] args) {
        String a = "0";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        String result="";
        String[] as = a.split("");
        String[] bs = b.split("");
        String y = "0";
        for (int i = as.length - 1, j = bs.length - 1; i >= 0 || j >= 0; i--, j--) {
            String x;
            String l = i >= 0 ? as[i] : "0";
            String m = j >= 0 ? bs[j] : "0";
            int r = Integer.parseInt(l) + Integer.parseInt(m) + Integer.parseInt(y);
            y = r / 2 + "";
            result=r%2+result;
        }
        if ("1".equals(y)){
            result="1"+result;
        }
        return result;
    }
}
