package No_1_200.No105从前序与中序遍历序列构造二叉树;

public class Solution {
    public static void main(String[] args) {
        int[] preorder = {1,2,3}, inorder = {3,2,1};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println("0");
    }

    /**
     * 使用递归，先序遍历数组的第一位一定是根节点，在中序遍历序列中找到根节点，则中序遍历
     * 的左侧序列为左子树的中序遍历，右侧序列为右子树的中序遍历，再根据中序遍历的长度，在
     * 前序遍历序列中找到子树的前序遍历序列，递归构造子树
     * 递归的退出条件：如果截取的子树遍历序列长度为1，则只构造节点并拼接到父节点上
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        builde(preorder, 1, preorder.length - 1, inorder, 0, inorder.length - 1, root);
        return root;
    }


    public static void builde(int[] preoder, int s1, int e1, int[] inorder, int s2, int e2, TreeNode parent) {
        int indexOfParent = -1;
        for (int i = s2; i < e2 + 1; i++) {
            if (inorder[i] == parent.val) {
                indexOfParent = i;
                break;
            }
        }
        int leftLength = indexOfParent - s2;
        int rightLength = e2 - indexOfParent;
        if (leftLength == 0) {
            parent.left=null;
        }
        if (leftLength == 1) {
            parent.left=new TreeNode(preoder[s1]);
        }
        if (rightLength == 0) {
            parent.right=null;
        }
        if (rightLength == 1) {
            parent.right=new TreeNode(preoder[s1 + leftLength]);
        }
        if (leftLength > 1){
            parent.left=new TreeNode(preoder[s1]);
            builde(preoder, s1 + 1, s1 + leftLength, inorder, s2, indexOfParent - 1, parent.left);
        }
        if (rightLength > 1){
            parent.right=new TreeNode(preoder[s1 + leftLength]);
            builde(preoder, s1 + leftLength + 1, e1, inorder, indexOfParent + 1, e2, parent.right);
        }


    }
}
