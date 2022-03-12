package solutions;

import java.util.Arrays;
import java.util.Collections;

public class Solution128 {
    int max=0;

    public int longestConsecutive(int[] nums){



        Arrays.sort(nums);
        int i = sublongestConsecutive(nums);
        return i;


    }
    public int sublongestConsecutive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int j=i;
            while (j+1<nums.length&&nums[j+1]==nums[j]+1){
                j++;
            }
            max=Math.max(max,j-i+1);
            i=j;
        }

        return max;
    }
}
