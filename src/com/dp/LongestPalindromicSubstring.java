package com.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }

        int n = s.length();

        String res = null;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }


        if(n > 1){
            for(int i = 0; i < n-1; i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    dp[i][i+1] = true;
                    res = s.substring(i,i+2);
                }
            }
        }

        if( n > 2){
            for(int l =3;l <= n; l++){
                for(int i = 0; i+l <= n; i++){
                    int j = i + l - 1;
                    if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                        if (l > res.length()){
                            res = s.substring(i,j+1);
                        }

                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bb"));
    }
}
