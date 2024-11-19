package com.example.springdemowebbasic.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author rival
 * @since 2024-11-15
 */

@Log4j2
public class SpringFilter extends OncePerRequestFilter {

    private final AntPathMatcher antPathMatcher;
    private final String pattern;

    public SpringFilter(String pattern) {
        this.antPathMatcher = new AntPathMatcher();
        this.pattern = pattern;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull  HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        boolean match = antPathMatcher.match(pattern, requestURI);
        if(match){
            log.info("====SpringFilter filter chain before====");
            filterChain.doFilter(request,response);
            log.info("====SpringFilter filter chain After====");
        }else{
            filterChain.doFilter(request,response);

        }

    }
}
