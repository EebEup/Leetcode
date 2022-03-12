package solutions;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
       return nodeEqual(root.left,root.right);


    }


    boolean nodeEqual(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null) return true;
        if(t1==null||t2==null) return false;
        if(t1.val!=t2.val) return false;

        return nodeEqual(t1.left,t2.right)&&nodeEqual(t1.right,t2.left);

    }

}
