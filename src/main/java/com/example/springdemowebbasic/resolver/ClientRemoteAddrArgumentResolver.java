package com.example.springdemowebbasic.resolver;

import com.example.springdemowebbasic.annotation.ClientRemoteAddr;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author rival
 * @since 2024-11-16
 */

@Component
public class ClientRemoteAddrArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(@NonNull MethodParameter parameter) {
        return parameter.getParameterAnnotation(ClientRemoteAddr.class) != null;
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {


        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();


        return request.getRemoteAddr();
    }
}
