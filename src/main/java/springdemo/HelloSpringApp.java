package springdemo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String args[]) {

        //Load the spring configutation file
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrive bean from the conainer
        Coach theCoach = context.getBean("myCoach",Coach.class);

        //call methods on bean
        System.out.println(theCoach.getDailyWorkout());
        //call new method with bean
        System.out.println(theCoach.getFortune());

        //close the context
        context.close();

    }
}
