package cPractice.commonlyAskedQuestion;

public class ElementInRotatedArray {

    public static int rotatedArray(int[] arr,int key,int low, int high){
        int mid=(high+low)/2;
        if(low>high)
            return -1;

        if(arr[mid]==key)
            return mid;
        if(arr[low]<arr[mid]){  //left subArray is sorted
              /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if(key>arr[low] && key<=arr[mid])
                return rotatedArray(arr,key,low,mid-1);

            /*If key not lies in first half subarray,
           Divide other half  into two sub arrays,
           such that we can quickly check if key lies
           in other half */
            return rotatedArray(arr,key,mid+1,high);

        }else{    //right subArray must be sorted

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
