package com.example.springdemowebbasic.config;

import com.example.springdemowebbasic.filter.SpringFilter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
