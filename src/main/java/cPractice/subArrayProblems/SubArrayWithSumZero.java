package cPractice.subArrayProblems;

import java.util.HashSet;

public class SubArrayWithSumZero {

    public void isZeroSum(int[] arr,int n) {

        HashSet<Integer> hs=new HashSet<>();
        int currentSum=0;

        for(int i=0; i < n;i++){
            currentSum=currentSum+arr[i];
            if(hs.contains(currentSum) || arr[i]==0){
                System.out.println("true");
                break;
            }
            hs.add(currentSum);
        }
    }

        public static void main(String args[]) {
        int[] arr = {1, 4, -2, -2, 5, -4, 3};
        SubArrayWithSumZero subArrayWithSumZero = new SubArrayWithSumZero();
        subArrayWithSumZero.isZeroSum(arr, arr.length);
    }
}
