package com.lwb.learn.designpatterns.TemplateMethod;

public class ConcreteSort extends AbstractSort {
    @Override
    protected void sort(int[] array) {
        bubbleSort(array);
    }

    private void bubbleSort(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=0;j<array.length-i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
