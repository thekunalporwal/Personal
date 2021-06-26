package springdemoAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

public class JavaConfigDemoApp {

    public static void main (String args[])
    {

        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);

        Coach1 theCoach = context.getBean("tenisCoach",Coach1.class);

        //call methods on bean
        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());


        //close the context
        context.close();

    }
}
