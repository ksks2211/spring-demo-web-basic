package com.example.springdemowebbasic.interceptor;

import com.example.springdemowebbasic.annotation.InterceptQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 * @author rival
 * @since 2024-11-18
 */

@Component
@Log4j2
public class QueryInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {

        String uri = request.getRequestURI();
        log.info("Request URI : {}", uri);



        HandlerMethod handlerMethod = (HandlerMethod) handler;
        InterceptQuery methodAnnotation = handlerMethod.getMethodAnnotation(InterceptQuery.class);

        if(null != methodAnnotation){
            String query = request.getQueryString();
            log.info("Query-key : {}", methodAnnotation.value());
            log.info("Actual-Query : {}", query);
        }



        return true;
    }



}
