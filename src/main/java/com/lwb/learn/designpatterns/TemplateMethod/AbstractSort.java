package com.lwb.learn.designpatterns.TemplateMethod;

public abstract class AbstractSort {

    /**
     * 将数组array由小到大排序
     * @param array
     */
    protected abstract void sort(int[] array);

    public void showSortResult(int[] array){
        this.sort(array);
        System.out.println("排序结果");
        for(int i : array){
            System.out.print(i+" ");
        }
    }
}
