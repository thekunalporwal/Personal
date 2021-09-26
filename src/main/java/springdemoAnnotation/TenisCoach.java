package springdemoAnnotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Component()
public class TenisCoach implements Coach1 {

    @Value("${foo.email}")
    private String email;

    //field Injection
    @Autowired()
    @Qualifier("happyFortuneService3")
    private FortuneService1 fortuneService1;

    //Define a Constructor method

    @Autowired
    public TenisCoach(FortuneService1 fortuneService3){
        fortuneService1=fortuneService3;
    }

    //Default Constructor
    public TenisCoach(){
        System.out.println("Default");
    }

    //Define a setter method
    @Autowired
    public void anyMethodName(FortuneService1 fortuneService2)
    {
        fortuneService1=fortuneService2;
    }

    @Override
    public String getDailyWorkout() {
        System.out.println(email);
        return "Spend 60 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService1.getFortune();
    }

}
