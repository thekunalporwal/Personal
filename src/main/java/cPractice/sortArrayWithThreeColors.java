package cPractice;

import java.util.Arrays;

public class sortArrayWithThreeColors {

    public void sort(int[] arr,int n) {
        int low=0;
        int mid=0;
        int high=n-1;
        int temp;

            while (mid<high){
                if(arr[mid]==1)
                    mid++;

                if(arr[mid]==0){
                    temp=arr[low];
                    arr[low]=arr[mid];
                    arr[mid]=temp;
                    low++;
                }
                if(arr[mid]==2){
                    temp=arr[high];
                    arr[high]=arr[mid];
                    arr[mid]=temp;
                    high--;
                }
        }

            System.out.println(Arrays.toString(arr));

    }


        public static void main(String args[]) {
        int[] arr = {1, 2,0,0,1,0,0,2};
        sortArrayWithThreeColors soryAraryWithThreeColors = new sortArrayWithThreeColors();
        soryAraryWithThreeColors.sort(arr,arr.length);
    }
}
