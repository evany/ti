package com.array;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int res = 0;
        int[] profit1 = maxProfit(prices, 0, prices.length -1);
        res = profit1[0];
        int leftProfit = 0;
        int rightProfit = 0;

        if(profit1[0] > 0){
            if(profit1[1] >1){
                leftProfit = maxProfit(prices, 0, profit1[1]-1)[0];
            }
            if(profit1[2] < prices.length -1){
                rightProfit = maxProfit(prices, profit1[2]+1, prices.length -1)[0];
            }
        }

        res += Math.max(leftProfit, rightProfit);
        return res;
    }


    private int[] maxProfit(int[] prices, int start, int end){
        if(start >= end){
            return new int[]{0, start, end};
        }
        int min = prices[start];
        int max = 0;
        int currentMinIndex = start;
        int minIndex = start;
        int maxIndex = start;
        for(int i = start+1; i <= end;i++){
            if(prices[i] <= min){
                currentMinIndex = i;
                min = prices[i];
            }else{
                int temp = prices[i] - prices[currentMinIndex];
                if(temp > max){
                    max = temp;
                    minIndex = currentMinIndex;
                    maxIndex = i;
                }
            }
        }
        System.out.println(max);
        System.out.println(minIndex);
        System.out.println(maxIndex);
        return new int[]{max, minIndex, maxIndex};
    }

    public static void main(String[] args) {
        System.out.println("蝭".getBytes().length);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int a = map.getOrDefault('a',0);
//        System.out.println(new BestTimeToBuyAndSellStock3().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
