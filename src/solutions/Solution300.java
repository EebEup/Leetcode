package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution300 {


        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0]=1;
            for(int i=1;i<nums.length;i++){
                int j=i;
                int flag=0;
                for(;j>=0;j--){
                    if(nums[j]<nums[i]){
                        dp[i]=dp[j]+1;
                        flag=1;
                        break;
                    }

                }

                if(flag==0){
                    dp[i]=1;
                }
            }
            int ans=0;
            for(int i=0;i<nums.length;i++){
                if(dp[i]>=ans){
                    ans=dp[i];
                }
            }

            return ans;


        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String[] s=scanner.nextLine().split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i]=Integer.valueOf(s[i]);
        }
        Solution300 solution300 = new Solution300();
        System.out.println(solution300.lengthOfLIS(nums));


    }

}
