package No_1_200.No111二叉树的最小深度;

public class Solution {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = e;
//        b.left = f;
//        b.right = d;
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        int i=Integer.MAX_VALUE;
        if (root.left!=null){
            i=Math.min(minDepth(root.left),i);
        }
        if (root.right!=null){
            i=Math.min(minDepth(root.right),i);
        }
        return i+1;
    }
}
