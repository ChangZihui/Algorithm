package No_1_200.No104二叉树的最大深度;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(6);
//        root.left = a;
//        root.right = b;
//        a.left = c;
//        a.right = e;
//        b.left = f;
//        b.right = d;
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        Map<String,Integer> map=new HashMap<>();
        map.put("maxDepth",0);
        map.put("currentDepth",0);
        visit(root,map);
        return map.get("maxDepth");
    }
    public static void visit(TreeNode node, Map<String,Integer> map) {
        if (node == null) {
            return;
        }
        map.put("currentDepth",map.get("currentDepth")+1);
        if (node.left != null) {
            visit(node.left,map);
        }
        if (node.right != null) {
            visit(node.right, map);
        }
        if (map.get("currentDepth")>map.get("maxDepth")){
            map.put("maxDepth",map.get("currentDepth"));
        }
        map.put("currentDepth",map.get("currentDepth")-1);
    }
}
