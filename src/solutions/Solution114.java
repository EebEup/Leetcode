package solutions;

public class Solution114 {
    public void flatten(TreeNode root) {

        if(root.left==null)  return;
        flatten(root.left);
        TreeNode leftEnd = getLeftEnd(root.left);
        TreeNode right =root.right;
        flatten(right);
        leftEnd.right=right;
        root.right=root.left;
        root.left=null;


    }

    TreeNode getLeftEnd(TreeNode t){
        while(t.right!=null){
            t=t.right;
        }
        return t;
    }

    public void subflatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        flatten(right);
        root.right = right;
    }

}
