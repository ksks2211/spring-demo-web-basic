package com.example.springdemowebbasic.config;

import com.example.springdemowebbasic.interceptor.QueryInterceptor;
import com.example.springdemowebbasic.resolver.ClientRemoteAddrArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author rival
 * @since 2024-11-11
 */

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final ClientRemoteAddrArgumentResolver resolver;
    private final QueryInterceptor queryInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(queryInterceptor).addPathPatterns("/interceptor/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(resolver);
    }
}
