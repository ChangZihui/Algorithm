package No_1_200.No108将有序数组转换为二叉搜索树;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 8};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println("转换完成");
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return change(nums, 0, nums.length - 1);
    }

    public static TreeNode change(int[] nums, int l, int r) {
        if (l > r || l < 0 || r > nums.length - 1) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        TreeNode treeNode = new TreeNode(nums[(l + r) / 2]);
        treeNode.left = change(nums, l, (l + r) / 2 - 1);
        treeNode.right = change(nums, (l + r) / 2 + 1, r);
        return treeNode;
    }
}

