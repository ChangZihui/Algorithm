package No_1_200.No058最后一个单词的长度;

public class Solution {
    public static void main(String[] args) {
        String s="Hello World";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        int length=0;
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i >=0; i--) {
            if (length>0&&chars[i]==' '){
                break;
            }
            if (chars[i]==' '){
                continue;
            }
            length++;
        }

        return length;
    }
}
