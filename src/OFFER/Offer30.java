package OFFER;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Offer30 {
    class MinStack {
        Deque<Integer> stack;
        int min=Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {
           stack =new LinkedList<>();
        }

        public void push(int x) {
            if(x<min) min =x;
            stack.push(x);
        }

        public void pop() {
            if(stack.isEmpty()) return ;
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
             return min;
        }
    }

}
