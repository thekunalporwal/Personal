package javaMiscellaneous.multithreading.questions.print123;

public class Alternate123Part2 {

    private volatile Integer number = 1;
    private volatile Integer threadIdToRun = 1;
    private Object monitor = new Object();

    public static void main(String[] args) {

        Alternate123Part2 testClass = new Alternate123Part2();
        Thread t1 = new Thread(testClass.new Printer(1));
        Thread t2 = new Thread(testClass.new Printer(2));
        Thread t3 = new Thread(testClass.new Printer(3));

        t1.start();
        t2.start();
        t3.start();
    }

    class Printer implements Runnable {
        int threadId;

        Printer(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {

            try {
                while (number < 10) {
                    synchronized (monitor) {
                        if (threadId != threadIdToRun) {
                            monitor.wait();
                        } else {
                            System.out.println("Thread " + threadId + " printed " + threadIdToRun);
                            number++;
                            if (threadId == 1)
                                threadIdToRun = 2;
                            else if (threadId == 2)
                                threadIdToRun = 3;
                            else if (threadId == 3)
                                threadIdToRun = 1;

                            monitor.notifyAll();
                        }
                    }
                }
            } catch (Exception e) {

            }
        }
    }
}

