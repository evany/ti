package com.binary;

public class BinarySearch {
    public int search(int[] arr, int val){

        int i = 0, j = arr.length - 1;
        double a = 2.1d;

        double b = a - i;
        System.out.println(a > i);
        while(i !=j ){
            int mid = i + (j - i)/2;
            if(arr[mid] < val){
                i = mid + 1;
            }else{
                j = mid;
            }
        }
        return arr[i];
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{1,2,5}, 3));

    }

}
