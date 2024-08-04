package javaMiscellaneous.multithreading.questions.evenOdd2threads;

public class EvenOddLogic {

    volatile int counter = 0 ;
    int limit;

    EvenOddLogic(int limit){
        this.limit=limit;
    }

    public synchronized void printEvenNumber() throws InterruptedException {

        while (counter < limit) {
            if (counter % 2 == 0) {
                System.out.println("Number is even with " + Thread.currentThread().getName()+ " "  + counter);
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void printOddNumber() throws InterruptedException {
        while (counter < limit) {

            if (counter % 2 != 0) {
                System.out.println("Number is odd "+ Thread.currentThread().getName()+ " "  + counter);
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }


}
