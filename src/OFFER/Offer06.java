package OFFER;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> res =new Stack<>();
        while(head!=null){
            res.push(head.val);
            head=head.next;
        }
        int[] ans = new int[res.size()];
        int size=res.size();
        for(int i=0;i<size;i++){
            ans[i]=res.pop();
        }
        return ans;
    }

}
