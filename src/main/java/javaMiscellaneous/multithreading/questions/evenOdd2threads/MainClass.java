package javaMiscellaneous.multithreading.questions.evenOdd2threads;

public class MainClass {

    public static void main(String[] args) {
        EvenOddLogic sp = new EvenOddLogic(50);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sp.printEvenNumber();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sp.printOddNumber();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
