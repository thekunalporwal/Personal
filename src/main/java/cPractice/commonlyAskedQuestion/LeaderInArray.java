package cPractice.commonlyAskedQuestion;

public class LeaderInArray {
    public static void leaderArray(int[] arr , int n) {

        int maxSoFar=arr[n-1];

//        System.out.println(n);
        for(int i=n-1; i>=0; i--){
            if(arr[i]>=maxSoFar){
                maxSoFar=arr[i];
            }
        }

        System.out.println(maxSoFar);
    }

    public static void main(String args[]) {
        int arr[] = new int[] { 0, 6, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
         leaderArray(arr,arr.length);
    }
}
