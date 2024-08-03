package springdemoAnnotation.springBoot.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class CustomRequestLoggingFilter extends AbstractRequestLoggingFilter {

    @Override
    protected void beforeRequest(@NotNull HttpServletRequest request, String message) {
        // Log the message before the request is processed
//        System.out.println("Inside CustomRequestLoggingFilter beforeRequest method");
        logger.info(message);
    }

    @Override
    protected void afterRequest(@NotNull HttpServletRequest request, String message) {
        // Log the message after the request is processed
        String path = request.getRequestURI();
        //Request Body contains sensitive data, don't print the logs for this controller.
        if (StringUtils.containsIgnoreCase(path, "/api/v1/kunnu"))
            return;

        logger.info(message);
    }
}
