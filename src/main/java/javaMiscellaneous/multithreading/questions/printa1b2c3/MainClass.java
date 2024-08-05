package javaMiscellaneous.multithreading.questions.printa1b2c3;


public class MainClass {



    public static void main (String args[]){

        PrintMethod printMethod=new PrintMethod();

        Thread T1 =new Thread( () -> {
            for (int i = 0; i < 26; i ++){
                printMethod.printAbc();
            }

        }, "1");


        Thread T2 = new Thread( () -> {
            for (int k = 0; k < 26; k ++){
                printMethod.print123();
            }

        }, "2");

        T1.start();
        T2.start();
    }
}
