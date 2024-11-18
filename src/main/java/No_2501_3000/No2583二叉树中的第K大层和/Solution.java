package No_2501_3000.No2583二叉树中的第K大层和;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode6);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8, treeNode2, treeNode1);
        TreeNode treeNode9 = new TreeNode(9, treeNode3, treeNode7);
        TreeNode treeNode5 = new TreeNode(5, treeNode8, treeNode9);
        System.out.println(kthLargestLevelSum(treeNode5, 2));
    }


    public static long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sumList = new ArrayList<>();
        long sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> nexeQueue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) nexeQueue.add(node.left);
            if (node.right != null) nexeQueue.add(node.right);
            sum += node.val;
            if (queue.isEmpty()) {
                sumList.add(sum);
                sum = 0;
                queue = new ArrayDeque<>(nexeQueue);
                nexeQueue.clear();
            }
        }
        Collections.sort(sumList);
        if (sumList.size() < k) return -1;
        return sumList.get(sumList.size() - k);
    }
}
