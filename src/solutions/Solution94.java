package solutions;

import java.util.List;
import java.util.ArrayList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }



public class Solution94 {
    List<Integer> res =new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        f(root);
        return res;
    }
    void f(TreeNode a){
        if(a==null) return;
        f(a.left);
        res.add(a.val);
        f(a.right);

    }


}