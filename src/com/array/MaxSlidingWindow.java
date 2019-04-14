package com.array;
import java.util.*;
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];

        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0;
        for(int i = 0; i < n ;i++){
            while(!q.isEmpty() && q.peek() < i - k + 1){//change to if?
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                res[ri++] = nums[q.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums  = {1,3,-1,-3,5,3,6,7};//, and k = 3
        int k = 3;
        int[] res = new MaxSlidingWindow().maxSlidingWindow(nums, k);
    }
}
