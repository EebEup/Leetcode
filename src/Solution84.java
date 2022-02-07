import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {
    //暴力解法
    /*
    public int largestRectangleArea(int[] heights) {
        int max=0;

        for(int i=0;i<heights.length;i++){
            max=Math.max(max,(getr(heights,i)-getl(heights,i)+1)*heights[i]);
        }
    return max;

    }
    int getl(int[] heights,int i){
        for(int j=i;j>=0;j--){
            if(heights[j]<heights[i]) return j+1;
        }
        return 0;
    }
    int getr(int[] heights,int i){
        for(int j=i;j<heights.length;j++) {
            if (heights[j] < heights[i]) {
                return j - 1;
            }
        }
        return heights.length-1;
    }

    */


        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Deque<Integer> mono_stack = new ArrayDeque<Integer>();
            for (int i = 0; i < n; ++i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
                mono_stack.push(i);
            }

            mono_stack.clear();
            for (int i = n - 1; i >= 0; --i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
                mono_stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }





}
