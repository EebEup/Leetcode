import java.util.*;

public class Solution102 {
    List<List<Integer>> res =new ArrayList<>();
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        travel(root,1);
        for(List value:map.values()){
            res.add(value);
        }


        return res;
    }

    void travel(TreeNode t,int level){
        if(t==null) return;
        level++;
       if(!map.containsKey(level)){
           ArrayList<Integer> integers = new ArrayList<>();
           integers.add(t.val);
           map.put(level,integers);
       }else{
           map.get(level).add(t.val);
       }
        travel(t.left,level);
        travel(t.right,level);


    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }



}
