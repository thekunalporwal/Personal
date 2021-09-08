package codingPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumZero {

    public void sumZero(int[] arr){

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
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
                         System.out.println("inside loop");
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


    public static void main(String args[]){
        int[] arr={-1,0,1,2,-1,-4};
        TripletSumZero tripletSumZero=new TripletSumZero();
        tripletSumZero.sumZero(arr);
    }
}
