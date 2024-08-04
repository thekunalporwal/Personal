package springdemoAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springdemoAnnotation.springBoot.interceptor.CustomRequestLoggingFilter;

@SpringBootApplication
public class DarkWeb {

	public static void main(String[] args) {
		//http://localhost:8282/actuator/health
		SpringApplication.run(DarkWeb.class, args);
	}

	//Both interceptor and filter can be used to log the request and response.
	@Bean
	public CustomRequestLoggingFilter requestLoggingFilter() {
		CustomRequestLoggingFilter filter = new CustomRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludeClientInfo(true);
		filter.setIncludePayload(true);
		filter.setIncludeHeaders(true);
		filter.setMaxPayloadLength(1024);
		filter.setAfterMessagePrefix("<<REQUEST RECEIVED>>");
		return filter;
	}
}
