package 关键节点;


public class Solution {
    public static void main(String[] args) {
        int[] ints = {3, 1, 4, 3, -1, 1, 5};
        System.out.println(test(ints));
    }

    public static int test(int[] tree) {
        int count = 0;
        for (int i = 0; i < tree.length; i++) {
            if (is(tree, i)) {
                count++;
            }
        }
        return count;

    }

    public static boolean is(int[] tree, int i) {
        if (tree[i] == -1) return false;
        if (i==0) return true;
        int j = i;
        while ((j + 1) / 2 > 0) {
            if (tree[i] < tree[j]) {
                return false;
            }
            j = (j + 1) / 2;
            if (j==1){
                break;
            }
        }
        return true;
    }
}
