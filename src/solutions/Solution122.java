package solutions;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int profit=0;

        for(int i=0;i<prices.length;i++){
            if(i<prices.length-1&&prices[i+1]>prices[i]){
                int start =prices[i];
                while(i+1<prices.length&&prices[i+1]>prices[i]){
                    i++;
                }
                profit+=prices[i]-start;
            }
        }
        return profit;
    }
}
