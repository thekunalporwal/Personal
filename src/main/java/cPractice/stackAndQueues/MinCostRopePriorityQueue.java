package cPractice.stackAndQueues;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostRopePriorityQueue {

    public static void findMinCost(List<Integer> costList){

        PriorityQueue<Integer> queue=new PriorityQueue<>(costList);
        int cost=0;
        while(queue.size()>1){

            int min1=queue.poll();
            int min2=queue.poll();
            int sum=min1+min2;
            queue.add(sum);
            cost=cost+sum;
        }
        System.out.println("Cost is "+cost);
    }

    public static void main (String[] args) {

        List<Integer> costList= Arrays.asList(5,4,2,8);
        findMinCost(costList);
    }
}
