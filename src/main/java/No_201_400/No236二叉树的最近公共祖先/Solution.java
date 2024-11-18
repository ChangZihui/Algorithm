package No_201_400.No236二叉树的最近公共祖先;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static Map<TreeNode, List<TreeNode>> map = new HashMap<>();

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
        System.out.println(lowestCommonAncestor(treeNode3, treeNode5, treeNode4).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q, new ArrayList<>());
            List<TreeNode> nodeList1 = map.get(p);
            List<TreeNode> nodeList2 = map.get(q);
            for (int i = 0; i < nodeList1.size() || i < nodeList2.size(); i++) {
                if ((i + 1 == nodeList1.size() || i + 1 == nodeList2.size()) ||
                        nodeList1.get(i + 1).val != nodeList2.get(i + 1).val) {
                    return nodeList1.get(i);
                }
            }
            return null;
    }

    public static void dfs(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        if (node.val == p.val) {
            map.put(p, List.copyOf(list));
        }else if (node.val==q.val){
            map.put(q,List.copyOf(list));
        }

        dfs(node.left, p, q, list);
        dfs(node.right, p, q, list);
        list.remove(node);
    }


}
