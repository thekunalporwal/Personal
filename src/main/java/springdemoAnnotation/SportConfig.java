package springdemoAnnotation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("springdemoAnnotation")
@PropertySource("classpath:scratch.properties")
public class SportConfig {

    //define bean for sad fortune service
    @Bean
    public FortuneService1 fortuneService1(){
        return new HappyFortuneService1() ;
    }

}
