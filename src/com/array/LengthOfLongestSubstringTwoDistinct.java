package com.array;

import java.util.Map;
import java.util.HashMap;

class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, distinctNum = 0;
        for(int i = 0, j = 0; j < s.length();j++){
            int jCount = map.getOrDefault(s.charAt(j) ,0);
            map.put(s.charAt(j), ++jCount);
            if( jCount == 1){
                distinctNum ++;
            }
            if(distinctNum <= 2){
                max = Math.max(max, j - i +1);
                continue;
            }

            while (i < j){
                int iCount = map.getOrDefault(s.charAt(i), 0);
                map.put(s.charAt(i), --iCount);
                if(iCount == 0){
                    distinctNum--;
                }
                i++;
                if(distinctNum <= 2){
                    max = Math.max(max, j - i +1);
                    break;
                }
            }

        }
        return max;
    }
}