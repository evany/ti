package com.binary;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while(l < r){
            int mid = l + (r - l)/2;
            if(x - arr[mid] > arr[mid + k] - x){
                l = mid + 1;
            }else{
                r = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(arr[l + i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int k = 4;
        int x = 3;
        System.out.println(new FindKClosestElements().findClosestElements(arr, k,x));
    }
}
