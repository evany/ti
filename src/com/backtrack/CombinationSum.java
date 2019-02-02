package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(candidates == null || candidates.length == 0) return res;
		Arrays.sort(candidates);

    	helper(candidates, target, 0, new ArrayList<Integer>(), res);

		return res;
    }

    private void helper(int[] cands, int target, int pos, List<Integer> cur, List<List<Integer>> res){
    	if(target == 0){
    		res.add(new ArrayList<Integer>(cur));
    		return;
    	}

    	for(int i = pos; i < cands.length; i++){
    		int newTarget = target - cands[i];
    		if (newTarget >= 0){
                cur.add(cands[i]);
                helper(cands, newTarget, i, cur, res);
                cur.remove(cur.size()-1);
    		}else{
    			break;
    		}
    	}
    }
}
