package No_1_200.No020有效括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s="(";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        boolean result=true;
        String[] split = s.split("");
        Stack<String> strings = new Stack<>();
        Map<String,String> map=new HashMap<>();
        map.put(")","(");
        map.put("]","[");
        map.put("}","{");
        for (String s1 : split) {
            if (map.get(s1)==null){
                strings.push(s1);
            }else {
                if (strings.isEmpty()||!map.get(s1).equals(strings.peek())){
                    result=false;
                    break;
                }else {
                    strings.pop();
                }
            }
        }
        if (!strings.isEmpty()){
            result=false;
        }
        return result;
    }

}
