package cPractice.subArrayProblems;

public class SubArrayWithGivenSum {
    public void maxSum(int[] arr,int result) {

        int current_sum=arr[0];
        int j=0;
        for(int i=1; i<arr.length ; i++){

            if(current_sum>result){

                while(current_sum>result && j<i-1){
                current_sum=current_sum-arr[j];
                    j++;
                }
            }

            if(current_sum==result){
                System.out.println(j + " " +(i-1));
//                break;
            }

                current_sum=current_sum+arr[i];

        }


    }

    public static void main(String args[]) {
        int[] arr = {15, 2, 4, 8, 9, 5, 1, 23};
        int result=23;
        SubArrayWithGivenSum maxSumSubArray = new SubArrayWithGivenSum();
        maxSumSubArray.maxSum(arr,result);
    }
}
