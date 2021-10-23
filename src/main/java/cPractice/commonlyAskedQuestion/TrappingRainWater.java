package cPractice.commonlyAskedQuestion;

import java.util.Arrays;

public class TrappingRainWater {

    public static int maxWater(int[] arr , int n) {

         int[] left=new int[n];
         int[] right=new int[n];
         int maximumWater=0;

         //store maximum from  array.
         int max=arr[0];
         left[0]=max;
         for(int i=1 ; i < n; i++){
             max=Math.max(arr[i],max);
             left[i]=max;
         }

        //store in Max array.
        int max2=arr[n-1];
         right[n-1]=max2;
        for(int i=n-2 ; i >= 0; i--){
            max2=Math.max(arr[i],max2);
            right[i]=max2;
        }

        for(int i=0 ; i<n; i++){
            maximumWater+=Math.min(left[i],right[i])-arr[i];
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        return maximumWater;
    }

        public static void main(String args[]) {
        int arr[] = new int[] { 3, 0, 2, 0, 4 };
        System.out.println(maxWater(arr,arr.length));
    }
}
