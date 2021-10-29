package springdemoAnnotation.springBoot.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class RegisterInterceptor implements WebMvcConfigurer {

    @Autowired
    private InterceptorClass interceptorClass;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorClass);
    }

}
