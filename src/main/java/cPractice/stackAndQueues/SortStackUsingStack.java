package cPractice.stackAndQueues;

import java.util.Stack;

public class SortStackUsingStack {

    public static void sortUsingStack(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> stack2=new Stack<>();


        for(int i= 0 ; i<arr.length ; i++)
            stack.push(arr[i]);

        while(!stack.isEmpty()){
            int current=stack.pop();

            while(!stack2.isEmpty() && current <stack2.peek()) {
                    stack.push(stack2.pop());
            }
            stack2.push(current);
        }
        System.out.println(stack2);
    }

        public static void main(String args[]) {
        int[] arr = {34, 3, 31, 98, 92, 23};
        sortUsingStack(arr);
    }
}
