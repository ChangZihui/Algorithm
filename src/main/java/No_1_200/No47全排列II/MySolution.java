package No_1_200.No47全排列II;

import java.util.*;

public class MySolution {

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        List<List<Integer>> list = permuteUnique(nums);
        for (List<Integer> integers : list) {
            System.out.println(integers.toString());
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 按照无重复数字获取所有排列
        Set<String> set = new HashSet<>();
        List<String> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num + "");
        }
        backtrack(nums.length, output, set, 0);
        // 将所有排列放到 set 中去重
        // 将去重后的排列放入 result 中
        for (String string : set) {
            String[] strings = string.split(",");
            List<Integer> list=new ArrayList<>();
            for (String s : strings) {
                list.add(Integer.parseInt(s));
            }
            result.add(list);
        }
        return result;
    }

    public static void backtrack(int n, List<String> output, Set<String> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(String.join(",", output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

}
