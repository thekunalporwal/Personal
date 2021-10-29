package cPractice;

public class MinimumSteps {

    public static int pointsToBeCovered(int[] A, int[] B) {

        int n=A.length;
        int sum=0;
        for(int i=0 ; i<n-1 ; i++){
            int avalue=(A[i+1]-A[i]);
            int bvalue=(B[i+1]-B[i]);

            sum+=avalue+bvalue-Math.min(avalue,bvalue);
        }
        return sum;
    }

    public static void main(String args[]){
        int arr1[]={1,4,5};
        int arr2[]={2,9,6};
       System.out.println(pointsToBeCovered(arr1,arr2));
    }

}
