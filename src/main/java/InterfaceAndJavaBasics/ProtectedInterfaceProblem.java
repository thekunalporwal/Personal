package InterfaceAndJavaBasics;

public interface ProtectedInterfaceProblem {

    //complie time error thrown.
    // protected void protectedMethod(int i);

    //NoBody defined.
    public void Method(int i);
    abstract void abstractMethod(int i);

    default int defaultMethod() {
        return 0;
    }

    static int staticMethod(){return 1;}
}
