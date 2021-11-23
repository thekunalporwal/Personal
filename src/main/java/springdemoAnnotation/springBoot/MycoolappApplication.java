package springdemoAnnotation.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MycoolappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MycoolappApplication.class, args);
	}
}
