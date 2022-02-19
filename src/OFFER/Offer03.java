package OFFER;

import java.util.HashSet;

public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])) return nums[i];
        }
        return -1;
    }
}
