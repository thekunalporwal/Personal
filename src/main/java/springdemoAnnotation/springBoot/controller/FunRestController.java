package springdemoAnnotation.springBoot.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/v1")
public class FunRestController {
		
	// expose "/" that return "Hello World"
	@GetMapping("/abc")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}
	
}












