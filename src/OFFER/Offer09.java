package OFFER;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class Offer09 {
    class CQueue {

        Deque<Integer> head;
        Deque<Integer> tail;
        public CQueue() {
            head=new LinkedList<>();
            tail=new LinkedList<>();


        }

        public void appendTail(int value) {

            tail.add(value);

        }

        public int deleteHead() {
            if(head.isEmpty()){
                int integer=tail.getFirst();
                tail.remove(tail.getFirst());
                return integer;
            }
            else{
               return head.pop();
            }
        }
    }
}
