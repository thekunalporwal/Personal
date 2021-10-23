package cPractice.stackAndQueues;

import java.util.Stack;

public class NextGreaterElement {

    public static void nextGreaterElement(int[] arr) {

        Stack<Integer> stack=new Stack<>();

        for(int i= arr.length -1 ; i>=0 ; i--){

            while(!stack.isEmpty() && stack.peek()<arr[i])
                    stack.pop();

            System.out.println(stack.isEmpty()? -1:stack.peek());
            stack.push(arr[i]);
        }
    }

        public static void main(String args[]){
        int[] arr={ 11, 13, 21, 3};
         nextGreaterElement(arr);
    }
}
