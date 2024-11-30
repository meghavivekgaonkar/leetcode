package com.problem.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k =0;
        while( i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                arr[k] = leftHalf[i];
                i++;
            }else{
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while(i < leftSize){
            arr[k] = leftHalf[i];
            i++;
            k++;
        }
        while(j < rightSize){
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    

    public static void sort(int[] arr){
        int len = arr.length;
        if(len < 2){
            return;
        }
        int mid = len/2;
        int[] leftHalf = new int[mid];
        int[] rightHalf= new int[len - mid];
        for(int i  = 0; i < mid; i++){
            leftHalf[i] = arr[i]; 
        } 
        for(int j=0,i = mid; i < len; j++){
            rightHalf[j] = arr[i];
            i++;
        }
        sort(leftHalf);
        sort(rightHalf);
        merge(arr, leftHalf, rightHalf);

    }
    public static void main(String[] args) {
        int[] arr =new int[]{ 6, 3, 4, 1, 5, 2, 7, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
