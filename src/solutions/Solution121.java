package solutions;

public class Solution121 {

    public int maxProfit(int[] prices) {
       int max=0;
       int dp[] =new int[prices.length];
       dp[0]=prices[0];
       for(int i=1;i<prices.length;i++){
           dp[i]=Math.min(dp[i-1],prices[i-1]);
           max=Math.max(max,prices[i]-dp[i]);
       }
       return max;
    }
}
