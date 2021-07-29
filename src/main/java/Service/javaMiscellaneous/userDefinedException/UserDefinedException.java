package Service.javaMiscellaneous.userDefinedException;

public class UserDefinedException extends Exception
{

    String name;
    public UserDefinedException(String message,String name){
        super(message);
        this.name=name;
    }
}
