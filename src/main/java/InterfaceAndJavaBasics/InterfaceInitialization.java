package InterfaceAndJavaBasics;

public interface InterfaceInitialization {
    void printMe();
}
class PrintTest implements InterfaceInitialization{
    public static void main(String args[]){

        //can't initiate like normal class.

//        InterfaceInitialization itrerface=new InterfaceInitialization();

        InterfaceInitialization itr=new InterfaceInitialization() {
            @Override
            public void printMe() {
                System.out.println("Hello");
            }
        };
        itr.printMe();
    }

    @Override
    public void printMe() {

    }
}
