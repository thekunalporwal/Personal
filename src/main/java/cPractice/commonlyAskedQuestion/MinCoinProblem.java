package cPractice.commonlyAskedQuestion;

public class MinCoinProblem {

    public int minCoin(int[] arr,int value){

        if(value==0)
            return 0;

        int result=Integer.MAX_VALUE;
        for(int i=0 ; i< arr.length ;i++){

            if(arr[i]<=value) {
                int subResult = minCoin(arr,value-arr[i] );

                if(subResult != Integer.MAX_VALUE && subResult+1<result)
                    result=subResult+1;
            }
        }
        return result;
    }



    public static void main(String args[]) {
        MinCoinProblem minCoinProblem=new MinCoinProblem();

        int arr[]={9, 6, 5, 1};
        int value=11;
        System.out.println(minCoinProblem.minCoin(arr,value));

    }
}
