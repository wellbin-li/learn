package com.lwb.learn;


import java.util.Arrays;
import java.util.concurrent.*;

public class Test1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int a[] = {8, 7, 9, 5, 4, 3, 2, 1};
        m1(a);
        System.out.println(Arrays.toString(a));

    }

    /**
     * 平均：O(n)
     * 最好：O(n)
     * 最坏：O(n^2)
     *
     * @param a
     * @return
     */
    public static void m1(int[] a) {
        int i, j;
        int step = a.length / 2;
        while (step >= 1) {
            for (int k = 1; k <= step; k++) {
                for (i = k; i < a.length; i += step) {
                    int key = a[i];
                    for (j = i - step; j >= 0 && key < a[j]; j -= step) {
                        a[j + step] = a[j];
                    }
                    a[j + step] = key;
                }
            }
            step /= 2;
        }
    }


}
