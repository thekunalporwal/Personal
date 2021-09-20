package cPractice;

import java.util.Random;

public class RandomF6Function {

    private int random2(){
        Random random=new Random();
        return random.nextInt(2)+1;
    }

    private void random3(){
        for (int i=0 ; i<24;  i++)
            System.out.println(random2()%2 +random2());
    }

    private int random6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private int random12() {
        for (int i=0 ; i<24;  i++) {
            System.out.println( random6() + (random6() % 2) * 6);
        }
        if (random6() % 2==0)
            return 6 + random6();
        else // if rand6() is odd
            return random6();
    }

    public static void main(String args[]){

        RandomF6Function randomF6Function=new RandomF6Function();
//        System.out.println(randomF6Function.random12());
        randomF6Function.random3();

    }
}
