package com.dp;

public class NumberDecoding {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
//        int[] dp = new int[s.length()+1];
//        dp[0] = 0;
//        dp[1] = 1;
        int prepreNum = 1;
        int preNum = 1;
        int result = 1;

        for (int i = 1; i < s.length(); i++) {
            char p = s.charAt(i - 1);
            char c = s.charAt(i);
            if (p != '1' && p != '2' && c == '0') {
                return 0;
            }

            if ((p == '1' && c >= '1' && c <= '9') || (p == '2' && c >= '1' && c <= '6') && c != '0') {
                result = prepreNum + preNum;
            }else{
                result = preNum;
            }
            if (i < s.length() - 1) {
                prepreNum = preNum;
                preNum = result;
            }
        }
        return result;
    }
}
