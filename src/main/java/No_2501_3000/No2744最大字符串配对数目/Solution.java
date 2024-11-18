package No_2501_3000.No2744最大字符串配对数目;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
       String[] words = {"cd","ac","dc","ca","zz"};
       System.out.println(maximumNumberOfStringPairs(words));
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        int result=0;
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.get(word)==null){
                map.put(reverse(word),1);
            }else {
                result++;
            }
        }
        return result;
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return  sb.toString();
}

}
