package com.example.springdemowebbasic.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author rival
 * @since 2024-11-18
 */
@Log4j2
public class SpringPatternFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("====SpringPatternFilter filter chain before====");
        filterChain.doFilter(request,response);
        log.info("====SpringPatternFilter filter chain After====");
    }
}
