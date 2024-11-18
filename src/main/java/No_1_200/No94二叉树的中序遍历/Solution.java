package No_1_200.No94二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2, treeNode7, treeNode4);
        TreeNode treeNode5 = new TreeNode(5, treeNode6, treeNode2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(1, treeNode0, treeNode8);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, treeNode1);
        List<Integer> integers = inorderTraversal(treeNode3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return list;
    }

    public static void dfs(TreeNode node,List<Integer> list){
        if (node==null) return;
        dfs(node.left,list);
        list.add(node.val);
        dfs(node.right,list);
    }
}
