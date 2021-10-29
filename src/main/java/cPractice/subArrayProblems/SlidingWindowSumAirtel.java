package cPractice.subArrayProblems;

import java.util.LinkedList;

public class SlidingWindowSumAirtel {

    public int maximum(int[] arr, int k){
        int n=arr.length;

        if(n<k)
            return -1;
        int maximumSum=0;
        for(int i=0 ; i<k ;i++){
            maximumSum+=arr[i];
        }

        int current=maximumSum;
        for(int j=k ; j<n ; j++){
            current+=arr[j]-arr[j-k];

            if(current>maximumSum){
                maximumSum=current;
            }
        }

        return maximumSum;
    }


    public void sortLinkedList(){
        LinkedList<Integer> list=new LinkedList<>();
        LinkedList<Integer> list2=new LinkedList<>();
        LinkedList<Integer> list3=new LinkedList<>();
    }


    public static void main(String args[]){

    }
}
