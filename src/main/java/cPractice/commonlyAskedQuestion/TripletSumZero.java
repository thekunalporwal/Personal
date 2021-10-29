package cPractice.commonlyAskedQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TripletSumZero {

    public void sumZero(int[] arr){

        Arrays.sort(arr);
        List<List<Integer>> list=new ArrayList<>();;

        for(int i=0 ; i<(arr.length)-2 ; i++){

            if((i > 0) && (arr[i] == arr[i-1])) {
                continue;
            }
          int Sum=-arr[i];
                 int firstPointer=i+1;
                 int lastPointer= (arr.length)-1;

                 while(firstPointer<lastPointer){
                     if(arr[firstPointer]+arr[lastPointer]==Sum){
                         List<Integer> list1=new ArrayList<>();
                         list1.add(-Sum);
                         list1.add(arr[firstPointer]);
                         list1.add(arr[lastPointer]);
                         list.add(list1);
                         firstPointer++;
                         lastPointer--;

                         while(firstPointer<lastPointer && arr[firstPointer]==arr[firstPointer-1])
                             firstPointer++;
                         while(firstPointer<lastPointer && arr[lastPointer]==arr[lastPointer+1])
                             lastPointer--;

                     }else if(arr[firstPointer]+arr[lastPointer]<Sum){
                         firstPointer++;
                     }else {
                         lastPointer--;
                     }
                 }

        }
        System.out.println(list);

    }

    static void sumZero(int[] arr,int n){
        boolean found=false;
        for(int i=0; i<n-1;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=i+1; j<n; j++){

                int x=-(arr[i]+arr[j]);
                if(hs.contains(x)){
                    System.out.println(x+" "+arr[i]+" "+arr[j]);
                }else
                    hs.add(arr[j]);
            }
        }
    }


    public static void main(String args[]){
        int[] arr={-1,0,1,2,-1,-4};
        TripletSumZero tripletSumZero=new TripletSumZero();
        tripletSumZero.sumZero(arr);
        sumZero(arr, arr.length);
    }
}
