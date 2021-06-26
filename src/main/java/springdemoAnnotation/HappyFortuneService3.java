package springdemoAnnotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService3 implements FortuneService1 {

	@Override
	public String getFortune()
	{
		return "Today is your lucky day again in forturneService 3!";
	}

}
