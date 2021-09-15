package cPractice;

public class RemoveParticularElement {

    public int removeDuplicates(int[] nums, int value) {
        int n = nums.length;
        if(n==1 && nums[0]==value)
            return 0;

        if (n == 0 || n==1)
            return n;

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != value) {
                nums[j] = nums[i];
                j++;
            }
        }
//        nums[j++] = nums[n - 1];
        return j;
    }

    public static void main(String args[]){
        int[] arr={3,2,2,3};
        RemoveParticularElement tripletSumZero=new RemoveParticularElement();
        System.out.println(tripletSumZero.removeDuplicates(arr,3));
    }
}
