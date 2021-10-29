package cPractice.commonlyAskedQuestion;

public class ShareBuyAndSellOnceOnly {
    public static int maxProfitBySellingOnce(int[] arr , int n) {
        if(n==0 || n==1)
            return 0;

        int maxSoFar=0;
        int minimum=arr[0];

        for(int i=1; i< n; i++){
            if(arr[i]<minimum)
                minimum=arr[i];

            if(arr[i]>minimum){
                maxSoFar=arr[i]-minimum;
            }
        }


        return maxSoFar;
    }

        public static void main(String args[]) {

        int price[] = { 1, 2, 90, 10, 110};
        int n = price.length;

        System.out.println(maxProfitBySellingOnce(price, n));
    }
}
