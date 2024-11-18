package No_401_1000.No993二叉树的堂兄弟节点;

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
        System.out.println(isCousins(treeNode3, 0, 6));
    }

    private static TreeNode parent1 = null;
    private static TreeNode parent2 = null;
    private static int depth1 = 0;
    private static int depth2 = 0;

    public static boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0);
        return depth1 == depth2 && parent1 != parent2;
    }

    public static int dfs(TreeNode node, int x, int y, int depth) {
        if (node == null) return -1;
        if (node.val == x) return x;
        if (node.val == y) return y;
        int dfs1 = dfs(node.left, x, y, depth + 1);
        int dfs2 = dfs(node.right, x, y, depth + 1);
        if (dfs1 == x || dfs2 == x) {
            parent1 = node;
            depth1 = depth + 1;
        }
        if (dfs1 == y || dfs2 == y) {
            parent2 = node;
            depth2 = depth + 1;
        }
        return -1;
    }
}

