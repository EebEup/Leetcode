package solutions;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution141 {


    public ListNode hasCycle(ListNode head) {
        HashSet<ListNode> lis = new HashSet<>();
        while(head!=null){
            if(lis.contains(head)){
                return head;
            }
            lis.add(head);
            head=head.next;
        }
        return null;
    }
}
