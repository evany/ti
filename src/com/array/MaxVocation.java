package com.array;

public class MaxVocation {

    public int max(int[] wr, int days){//0 for work, 1 for off
        if(wr == null || wr.length == 0) return 0;
        //todo process day 0 if work day, and only one day in list
        int res = 0, i = 0, j = 0, n = wr.length;
        while(i <= j && j < n){
            while(true){
                while (j < n && wr[j] >= 1) j++;
                if(days > 0){
                    wr[j++] = 2;
                    days--;
                }else{
                    break;
                }
            }
            res = Math.max(res, j - i + 1);
            while(true){
//                while(i <= j && )
            }


        }
        return res;
    }
}
