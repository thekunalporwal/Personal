package cPractice.commonlyAskedQuestion;

import java.util.Arrays;

public class MinimumPlatform {

    public void minPlatform(int arr[],int dep[]){

        Arrays.sort(arr);
        Arrays.sort(dep);
        int n=arr.length;

        int plat_needed = 1;
        int result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }

            // Else decrement count of platforms needed
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            // Update result if needed
            if (plat_needed > result)
                result = plat_needed;
        }

        System.out.println("Cost is "+result);
    }

    public static void main(String args[]){
        int arr[]={900, 940, 950, 1100, 1500, 1800};
        int dep[]={ 910, 1200, 1120, 1130, 1900, 2000 };

        MinimumPlatform minimumPlatform=new MinimumPlatform();
        minimumPlatform.minPlatform(arr,dep);
    }
}
