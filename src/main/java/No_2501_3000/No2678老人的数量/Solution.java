package No_2501_3000.No2678老人的数量;

public class Solution {

    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors(details));
    }
    public static int countSeniors(String[] details) {
        int i =0;
        for (String detail : details) {
            Integer age = Integer.valueOf(detail.substring(11, 13));
            if (age>60){
                i++;
            }
        }
        return i;
    }

}