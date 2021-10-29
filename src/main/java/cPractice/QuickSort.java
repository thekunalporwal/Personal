package cPractice;

import java.util.Arrays;

public class QuickSort {

    static void swapFUnction(int[] arr, int a ,int b){
        int swap=arr[a];
        arr[a]=arr[b];
        arr[b]=swap;
    }


    static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=(low-1);
        int j;
        for(j=low; j<=high;j++){
            if(pivot>arr[j]){
                i++;
                swapFUnction(arr,i,j);
            }
        }
        swapFUnction(arr,i+1,high);
        return i+1;
    }

    static  void sort(int[] arr,int low ,int high){
        if(low<high){
            int element=partition(arr,low,high);
            sort(arr,low,element-1);
            sort(arr,element+1,high);
        }
    }



    public static void main(String[] args){

        int[] arr={5,7,9,1,4,3};
        int n=arr.length;
        sort(arr,0,n-1);

        System.out.println(Arrays.toString(arr));
    }
}
