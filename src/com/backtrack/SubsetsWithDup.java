package com.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (nums == null || nums.length == 0) return res;
    	Arrays.sort(nums);
    	backTrack(nums, 0, new ArrayList<Integer>(), res);
    	return res;
    }

    private void backTrack(int[] nums, int pos, List<Integer> tempList, List<List<Integer>> res){
		res.add(new ArrayList<Integer>(tempList));
		for(int i = pos; i < nums.length;i++){
			if ( i > pos && nums[i] == nums[i-1]) continue;
			tempList.add(nums[i]);
			backTrack(nums, i+1, tempList, res);
			tempList.remove(tempList.size() - 1);
		}

    };
}
