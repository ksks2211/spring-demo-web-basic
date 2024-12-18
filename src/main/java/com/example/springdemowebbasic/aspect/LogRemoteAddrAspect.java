package com.example.springdemowebbasic.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author rival
 * @since 2024-11-15
 */

@Aspect
@Component
@Log4j2
public class LogRemoteAddrAspect {
    @Before("@annotation(com.example.springdemowebbasic.annotation.LogRemoteAddr) && args(request,..)")
    public void logRemoteAddrAspect(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        log.info("Remote User : "+remoteAddr);
    }
}
