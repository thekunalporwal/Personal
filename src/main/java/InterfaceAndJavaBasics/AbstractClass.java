package InterfaceAndJavaBasics;

public abstract class AbstractClass {

    abstract void methodAbstract();

    abstract void methodAbstract2();


    void methodNormal() {
        System.out.println("hehehe");
    }

    static void methodStatic(){
        System.out.println("hehehe");
    }


}

class normalClass extends AbstractClass{
    public static void
    main(String args[]){
        AbstractClass abs=new normalClass();
    }

    @Override
    void methodAbstract() {

    }

    @Override
    void methodAbstract2() {

    }
}
