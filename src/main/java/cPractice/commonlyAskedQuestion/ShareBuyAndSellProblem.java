package cPractice.commonlyAskedQuestion;

public class ShareBuyAndSellProblem {

    public static int maxProfit(int[] arr , int n){
        int profit=0;

        for(int i=1; i <n; i++){
            if(arr[i]>arr[i-1])
                profit+=(arr[i]-arr[i-1]);
        }
        return profit;
    }

    public static void main(String args[]) {

        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        System.out.println(maxProfit(price, n));
    }
}
