package com.binary;

public class FinMinimumInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0){ return 0; };
        int l = 0, r = nums.length - 1;
        while(l + 1 < r){
            int m = l + (r - l)/2;
            if(nums[r] == nums[m] ||nums[l] == nums[m]){
                while(r > m && nums[r] == nums[m]){
                    r--;
                }
                while(l < m && nums[l] == nums[m]){
                    l++;
                }
                continue;
            }


            if(nums[m] < nums[r]){
                r = m;
            }else if(nums[m] > nums[l]){
                l = m;
            }
        }

        return Math.min(nums[l], nums[r]);
    }
}
