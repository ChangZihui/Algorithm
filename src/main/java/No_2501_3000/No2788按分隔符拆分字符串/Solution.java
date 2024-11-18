package No_2501_3000.No2788按分隔符拆分字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("$easy$", "$problem$");
        char separator = '$';
        List<String> strings = splitWordsBySeparator(words, separator);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    String prev = word.substring(0, i);
                    if (!prev.isEmpty()) result.add(prev);
                    word = word.substring(i + 1);
                    i = -1;
                }
            }
            if (!word.isEmpty()) result.add(word);
        }
        return result;

    }

}
