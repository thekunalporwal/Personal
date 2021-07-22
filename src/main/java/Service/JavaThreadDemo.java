package Service;

public class JavaThreadDemo {

    public static void main(String args[]) {

        Thread thread=new Thread();
        thread.start();
        System.out.println(thread.getName().toString());

        thread.suspend();

    }
}
