import java.util.Deque;
import java.util.LinkedList;

public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
//        build(root,preorder,inorder);
        String pre = preorder.toString();
        String in = inorder.toString();
        build(root,pre,in);

        return root;
    }

    void build(TreeNode t,String pre,String in){
        if(pre.length()==1){
            t.val=pre.charAt(0);
            return;
        }
        t.val=pre.charAt(0);
        int index=0;
        for(int i=0;i<in.length();i++){
            if(in.charAt(i)==pre.charAt(0)){
                index=i;break;
            }
        }
        TreeNode left = new TreeNode();
        t.left=left;
        build(left,pre.substring(1,index),in.substring(0,index-1));

        TreeNode right=new TreeNode();
        t.right=right;
        build(right,pre.substring(index+1),in.substring(index+1));


    }


//    void build(TreeNode t,int[] pre,int[] in){
//        t.val=pre[0];
//
//       int index=0;
//        for (int i : in) {
//            if(i==pre[0]){
//                break;
//            }
//        }
//        int[] left= new int[index];
//        for (int i = 0; i < left.length; i++) {
//            left[i]=pre[i+1];
//        }
//        int[] right
//
//        build(new TreeNode(),);//leftTree
//
//
//
//    }
}
class SubSolution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}


