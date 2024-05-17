package springdemoAnnotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;


@Component()
public class TenisCoach implements Coach1 {
//
//    @Autowired
//    private HappyFortuneService2 happyFortuneService2;

    @Value("${foo.email}")
    private String email;

    @Autowired
    private Environment env;

    //field Injection
    @Autowired()
    @Qualifier("HappyFortuneService3")
    private FortuneService1 fortuneService1;

    //Define a Constructor method
//
//    @Autowired
//    public TenisCoach(FortuneService1 fortuneService3){
//        fortuneService1=fortuneService3;
//    }

    //Default Constructor
    public TenisCoach(){
        System.out.println("Default");
    }

//    //Define a setter method
//    @Autowired
//    public void anyMethodName(FortuneService1 fortuneService2)
//    {
//        fortuneService1=fortuneService2;
//    }

    @Override
    public String getDailyWorkout() {
        System.out.println(email);
        System.out.println(env.getProperty("foo.team"));
        return "Spend 60 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService1.getFortune();
    }

}
