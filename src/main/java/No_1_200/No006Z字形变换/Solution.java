package No_1_200.No006Z字形变换;

public class Solution {
    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        int gap = 2 * numRows - 2;
        if (numRows == 1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            while (i + j * gap + 2 * (numRows - i - 1) < s.length()) {
                stringBuilder.append(s.charAt(i + j * gap));
                if (i != 0 && i != numRows - 1) {
                    stringBuilder.append(s.charAt(i + j * gap + 2 * (numRows - i - 1)));
                }
                j++;
            }
            if (i + j * gap < s.length()) {
                stringBuilder.append(s.charAt(i + j * gap));
            }
        }
        return stringBuilder.toString();
    }
}
