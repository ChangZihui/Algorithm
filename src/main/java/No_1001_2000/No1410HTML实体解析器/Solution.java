package No_1001_2000.No1410HTML实体解析器;

import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String text = "&&&&;";
        System.out.println(entityParser(text));

    }


    static Map<String, String> entityMap = Map.of(
            "&quot;", "\"",
            "&apos;", "'",
            "&amp;", "&",
            "&gt;", ">",
            "&lt;", "<",
            "&frasl;", "/");

    public static String entityParser(String text) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if ('&' != text.charAt(i)) {
                string.append(text.charAt(i));
                continue;
            }
            if ('&' == text.charAt(i)) {
                String s = text.charAt(i) + "";
                if (i == text.length() - 1) {
                    string.append(s);
                    return string.toString();
                }
                for (int j = i + 1; j < text.length(); j++) {
                    if ('&' == text.charAt(j)) {
                        string.append(s);
                        i = j - 1;
                        break;
                    }
                    s += text.charAt(j);
                    if (j == text.length() - 1 && ';' != text.charAt(j)) {
                        string.append(s).append(text.charAt(j));
                        break;
                    }
                    if (';' == text.charAt(j)) {
                        String value = entityMap.get(s);
                        if (value == null) string.append(s);
                        else string.append(value);
                        i = j;
                        break;
                    }

                }
            }
        }
        return string.toString();
    }
}
