package com.example.springdemowebbasic.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author rival
 * @since 2024-11-15
 */

@WebFilter("/filter/*")
@Log4j2
public class ServletFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("====ServletFilter filter chain before====");
        chain.doFilter(request, response);
        log.info("====ServletFilter filter chain after====");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
