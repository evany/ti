package com.backtrack;

import java.util.List;
import java.util.ArrayList;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
    	backTrack(s, 0 ,new ArrayList<String>(), res);
    	return res;
    }

    private void backTrack(String s, int start, List<String> temp, List<List<String>> res){
        if (start == s.length()) {
			res.add( new ArrayList<String>(temp));
			return;
		}

		for(int i = start ; i < s.length() ; i++){
            if (isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i + 1));
				backTrack(s, i + 1, temp, res);
				temp.remove(temp.size() -1);
			}
		}
    }

    private boolean isPalindrome(String s, int start, int end){
    	while(start < end){
    		if (s.charAt(start ++) != s.charAt(end--)){
    			return false;
    		}
    	}
    	return true;
    }

}
