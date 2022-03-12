package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution239 {

    int max=Integer.MIN_VALUE;
    int mi=-1;
    int size=0;
    int[] nums;
        public int[] maxSlidingWindow(int[] nums, int k) {
            int l=0;
            int r=k-1;
            size=k;
            this.nums=nums;
            int[] ans=new int[nums.length-k+1];
            f(l,r);
            ans[0]=max;

            for(int i=1;i<nums.length-k+1;i++){
                l++;r++;
                if(mi==l-1){
                    f(l,r);
                    ans[i]=max;
                }
                else {
                    if(nums[r]>max){
                        mi=r;
                        max=nums[r];
                        ans[i]=max;
                    }
                }

            }
            return ans;

        }

        void f(int l,int r){
            for(int i=l;i<=r;i++){
                if(nums[i]>max){
                    max=nums[i];
                    mi=i;
                }
            }

        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution239 solution239 = new Solution239();
        int k=scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int[] ints = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ints[i]=list.get(i);
        }
       int[] ans= solution239.maxSlidingWindow(ints,k);
        scanner.close();
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            // 1. 优先队列存放的是二元组(num,index) : 大顶堆（元素大小不同按元素大小排列，元素大小相同按下标进行排列）
            // num :   是为了比较元素大小
            // index : 是为了判断窗口的大小是否超出范围
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
                public int compare(int[] pair1,int[] pair2){
                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0]:pair2[1] - pair1[1];
                }
            });

            // 2. 优选队列初始化 : k个元素的堆
            for(int i = 0;i < k;i++){
                pq.offer(new int[]{nums[i],i});
            }

            // 3. 处理堆逻辑
            int[] res = new int[n - k + 1];         // 初始化结果数组长度 ：一共有 n - k + 1个窗口
            res[0] = pq.peek()[0];                  // 初始化res[0] ： 拿出目前堆顶的元素
            for(int i = k;i < n;i++){               // 向右移动滑动窗口
                pq.offer(new int[]{nums[i],i});     // 加入大顶堆中
                while(pq.peek()[1] <= i - k){       // 将下标不在滑动窗口中的元素都干掉
                    pq.poll();                      // 维护：堆的大小就是滑动窗口的大小
                }
                res[i - k + 1] = pq.peek()[0];      // 此时堆顶元素就是滑动窗口的最大值
            }
            return res;
        }
    }









}
