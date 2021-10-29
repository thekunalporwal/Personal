package Service.javaMiscellaneous.singeletonAndImmutable;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class CustomSingleton implements Serializable {

    //Eager initialization if we make it Final
    private static final CustomSingleton singleInstance=new CustomSingleton();

    public String s;
    private CustomSingleton(){
        s="Hi Starting Singleton class.";
    }

    public static CustomSingleton CustomSingleton(){
            return singleInstance;
    }


    //Using Synchronized keyword and Lazy Initialization and can be broken by cloning.
    public static CustomSingleton getSingleInstance() {
        if (singleInstance == null) {
            synchronized (CustomSingleton.class) {
                if (singleInstance == null) {
//                    singleInstance = new CustomSingleton();
                }
            }
        }
        return singleInstance;
    }

    //to prevent breaking using input output stream
    private Object readResolve() throws ObjectStreamException {
        return singleInstance;
    }
}

class CheckSingleton{

    public static void main(String args[]) {
        CustomSingleton x = CustomSingleton.CustomSingleton();
        CustomSingleton y = CustomSingleton.CustomSingleton();
        CustomSingleton z = CustomSingleton.CustomSingleton();

        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
        System.out.println(z.hashCode());

    }
}
