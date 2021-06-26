package springdemoAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springdemo.Coach;

public class AnnotationDemoApp {

    public static void main (String args[])
    {

        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContextComponent.xml");

        Coach1 theCoach = context.getBean("tenisCoach",Coach1.class);

        //call methods on bean
        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());


        //close the context
        context.close();

    }
}
