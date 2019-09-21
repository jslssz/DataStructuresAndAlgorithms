package com.hx;

/**
 * @author jxlgcmh
 * @date 2019-09-09 20:16
 */
public class Demo6 {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 1;
        }
        int[] fib = new int[n + 1];
        fib[1]=1;
        for (int i = 2; i <=n; i++) {
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
}
