import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

}
