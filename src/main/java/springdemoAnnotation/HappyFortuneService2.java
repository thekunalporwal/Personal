package springdemoAnnotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService2 implements FortuneService1 {

	@Override
	public String getFortune()
	{

		return "Today is your lucky day again in service which impplements fortune service!";
	}

}
