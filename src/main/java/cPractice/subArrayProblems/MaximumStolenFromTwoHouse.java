package cPractice.subArrayProblems;

public class MaximumStolenFromTwoHouse {
    public static int maxStolen(int[] arr , int n) {

        if(n==1)
            return arr[0];
        if(n==2)
            return Math.max(arr[0],arr[1]);

        int maxArray[] = new int[n];
         maxArray[0]=arr[0];

        maxArray[1]=Math.max(arr[0],arr[1]);
        for(int i=2; i<n; i++){
            maxArray[i]=Math.max(maxArray[i-1],maxArray[i-2]+arr[i]);
        }

        return maxArray[n-1];

    }

    public static void main(String args[]) {

        int houseValue[] = {6,7,1,3,8,2,4};
        int n = houseValue.length;
        System.out.println(n);
        System.out.println(maxStolen(houseValue, n));
    }

}
