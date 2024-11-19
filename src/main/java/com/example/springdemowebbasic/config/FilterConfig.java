package com.example.springdemowebbasic.config;

import com.example.springdemowebbasic.filter.SpringFilter;
import com.example.springdemowebbasic.filter.SpringPatternFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author rival
 * @since 2024-11-15
 */

@Configuration
@ServletComponentScan(basePackages = "com.example.springdemowebbasic.filter")
public class FilterConfig {

    @Bean
    public SpringFilter springFilter(){
        return new SpringFilter("/filter/**");
    }

    @Bean
    public FilterRegistrationBean<SpringPatternFilter> customFilterRegistration(){
        FilterRegistrationBean<SpringPatternFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SpringPatternFilter());
        registrationBean.setUrlPatterns(List.of("/filter/**"));
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
