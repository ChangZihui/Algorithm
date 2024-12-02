package No_1_200.No58最后一个单词的长度;


public class MySolution {

    /**
     * 给你一个字符串s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
     */
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));

    }

    /**
     * 反向遍历字符串
     * 如果长度为0且当前是空格,就继续便利
     * 如果长度不为0且当前是空格,则说明遍历完了最后一个字符串,直接返回长度
     * 如果当前不是空格,则长度+1
     */
    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length == 0) continue;
                else break;
            }
            length++;
        }
        return length;
    }

}
