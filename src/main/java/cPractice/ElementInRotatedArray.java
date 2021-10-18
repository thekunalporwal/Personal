package cPractice;

public class ElementInRotatedArray {

    public static int rotatedArray(int[] arr,int key,int low, int high){
        int mid=(high+low)/2;
        if(low>high)
            return -1;

        if(arr[mid]==key)
            return mid;
        if(arr[low]<arr[mid]){
            if(key>arr[low] && key<=arr[mid])
                return rotatedArray(arr,key,low,mid-1);
            return rotatedArray(arr,key,mid+1,high);
        }else{
            if(key>arr[mid] && key<=arr[high])
                return rotatedArray(arr,key,mid+1,high);

                return rotatedArray(arr,key,low,mid-1);
        }

    }

    public static void main(String args[]){
        int[] arr={4,5,6,7,8,9,1,2,3};
        int key=6;
        System.out.println(rotatedArray(arr,key,0,(arr.length-1)));
    }
}
