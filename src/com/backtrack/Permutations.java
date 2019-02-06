package com.backtrack;

import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/permutations/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        backTrack(nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void backTrack(int[] nums, List<Integer> tempList, List<List<Integer>> res) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backTrack(nums, tempList, res);
            tempList.remove(tempList.size() - 1);
        }
    }
}
