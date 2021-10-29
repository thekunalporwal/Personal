package javaMiscellaneous.userDefinedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoException extends RuntimeException{
    public boolean ValidateName(String name) {
        Pattern pattern = Pattern.compile("^[A-Za-z]\\w{2,29}$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public boolean ValidateEmail(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }
    public boolean ValidateMobile(String number) {
        Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = pattern.matcher(number);
        return (match.find() && match.group().equals(number));
    }

    public static void main(String args[]) throws UserDefinedException {
        DemoException demoException=new DemoException();
        String name = "Geeksforgeeks";
        String mobile = "8182813888";
        String emailAddress = "abc-gmail.com";
        try{
        if(!demoException.ValidateName(name)){
            throw new UserDefinedException("Validation of Name failed",name);
        }
        if(!demoException.ValidateMobile(mobile)){
                throw new UserDefinedException("Validation of Number failed",mobile);
            }
        if(!demoException.ValidateEmail(emailAddress)){
                throw new UserDefinedException("Validation of EMAIL failed",emailAddress);
            }
        }catch (UserDefinedException exception){
            exception.printStackTrace();
        }catch (Exception e){
            System.out.println("Any other exception received like Null pointer/ FileNotFound");
            e.printStackTrace();
        }
    }
}
