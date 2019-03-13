package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> treePath = new ArrayList<>();
        if(root == null) return treePath;
        if(root.left==null&&root.right==null) treePath.add(String.valueOf(root.val));//遇到叶子节点
        String tmp = String.valueOf(root.val) + "->";
        for(String s:binaryTreePaths(root.left)) {
        	treePath.add(tmp + s);
        }
        for(String s:binaryTreePaths(root.right)) {
        	treePath.add(tmp + s);
        }
        return treePath;   
    }
}
