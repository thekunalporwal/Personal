package cPractice.commonlyAskedQuestion;

import java.util.Arrays;

public class RemoveDuplicatesArray {

    public int removeDuplicates(int[] nums){
     int n=nums.length;
     if(n==0 || n==1)
         return n;

     int j=0;
     for(int i=0 ; i < n-1; i++)
     {
         if(nums[i]!=nums[i+1]){
             nums[j]=nums[i];
             j++;
         }
     }
        nums[j++]=nums[n-1];

     return j;
    }

    public int[] removeDuplicates2(int[] nums) {

        int k= 1;

        for (int i=0; i< nums.length-1 ; i++){
            if(nums[i] != nums[i+1]){
                nums[k]=nums[i+1];
                k++;
            }
        }

        return nums;
    }


    public static void main(String args[]){
        int[] arr={1, 2, 2, 3, 4, 4, 4, 5, 5};
        RemoveDuplicatesArray tripletSumZero=new RemoveDuplicatesArray();
        int[] arr2= tripletSumZero.removeDuplicates2(arr);
        for (int j : arr2) {
            System.out.println(j);
        }
    }
}
