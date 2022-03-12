package solutions;

public class Solution104 {
    int ans=1;
    public int maxDepth(TreeNode root) {

        travel(root,0);
        return  ans;
    }

    void travel(TreeNode t,int depth){
        if(t==null) return;
        depth++;
        ans=Math.max(ans,depth);
        travel(t.left,depth);
        travel(t.right,depth);

    }

}
