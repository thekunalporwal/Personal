package javaMiscellaneous.userDefinedException;

public class ExceptionExample {

    public void generateException(){

        String str=null;

        try {
                char c= str.charAt(1);
                System.out.println("inside");
        }catch (Exception e) {
            throw e;
        }
    }

    public static void main(String args[]) throws Exception {


    }

}
