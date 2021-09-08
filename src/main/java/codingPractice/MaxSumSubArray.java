package codingPractice;

public class MaxSumSubArray {

    public void maxSum(int[] arr){

        int maxSum=0;
        int maxTill=0;

        for(int i=0 ;i<arr.length; i ++){
            maxTill=maxTill+arr[i];

            if(maxTill>maxSum)
                maxSum=maxTill;

            if(maxTill<=0)
            maxTill=0;
        }

        System.out.println(maxSum);
    }

    public void maxSumAlternate(int[] arr){

        int maxSum=arr[0];
        int maxTill=arr[0];

        for(int i=1 ;i<arr.length; i ++){
            maxTill=Math.max(maxTill+arr[i],arr[i]);
            maxSum=Math.max(maxSum,maxTill);
        }

        System.out.println(maxSum);
    }


    public static void main(String args[]){
        int[] arr={-1,4,5,-4,8};
        MaxSumSubArray maxSumSubArray=new MaxSumSubArray();
        maxSumSubArray.maxSum(arr);
        maxSumSubArray.maxSumAlternate(arr);
    }
}
