package No_201_400.No235二叉搜索树的最近公共祖先;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i).val != pathQ.get(i).val) {
                return pathP.get(i-1);
            }else {
                if (i==pathP.size()-1) return pathP.get(i);
                if (i==pathQ.size()-1) return pathQ.get(i);
            }
        }
        return null;
    }

    public static void findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        path.add(root);
        if (node.val == root.val) return;
        if (node.val < root.val) findPath(root.left, node, path);
        if (node.val > root.val) findPath(root.right, node, path);
    }
}
