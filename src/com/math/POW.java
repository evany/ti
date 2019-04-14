package com.math;

public class POW {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0){
            if(n == Integer.MIN_VALUE){
                n = Integer.MAX_VALUE - 1;
            }else{
                n = -n;
            }
            x = 1/x;
        }
        if((n & 1) == 1){
            return x * myPow(x * x, n/2);
        }else{
            return myPow(x * x, n/2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new POW().myPow(2, 10));
    }
}
