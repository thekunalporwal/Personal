package Service.thread.question1;

//Question 1 : WAP to print Deepak from one thread and Kumar from second thread infinitely.
public class TriggerThread {

    public static void main(String args[]) {

        Solution solution=new Solution() ;

        Thread t1=
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                    solution.printName();
                    }});

        Thread t2=
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        solution.printSurName();
                    }});

        t1.start();
        t2.start();
    }
}
