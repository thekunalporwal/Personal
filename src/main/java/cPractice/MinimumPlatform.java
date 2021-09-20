package cPractice;

import java.util.Arrays;

public class MinimumPlatform {

    public void minPlatform(int arr[],int dep[]){

        Arrays.sort(arr);
        Arrays.sort(dep);

        int first=0;
        int second=0;
        int hight= arr.length-1;
        int result=0;
        int resultTillNow=0;

        while(first<second){

        }

    }

    public static void main(String args[]){
        int arr[]={900, 940, 950, 1100, 1500, 1800};
        int dep[]={ 910, 1200, 1120, 1130, 1900, 2000 };

        MinimumPlatform minimumPlatform=new MinimumPlatform();
        minimumPlatform.minPlatform(arr,dep);
    }
}
