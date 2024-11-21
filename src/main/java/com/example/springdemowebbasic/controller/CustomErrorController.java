package com.example.springdemowebbasic.controller;

import com.example.springdemowebbasic.properties.CustomErrorProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author rival
 * @since 2024-11-19
 */

@Controller
@Log4j2
public class CustomErrorController extends AbstractErrorController {

    private final CustomErrorProperties errorProperties;

    public CustomErrorController(ErrorAttributes errorAttributes, CustomErrorProperties errorProperties) {
        super(errorAttributes);
        this.errorProperties = errorProperties;
    }


    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        log.info("Forwarded towards error controller!");
        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity<>(status);
        }
        Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request));
        return new ResponseEntity<>(body, status);
    }

    private ErrorAttributeOptions getErrorAttributeOptions(HttpServletRequest request) {
        ErrorAttributeOptions options = ErrorAttributeOptions.defaults();
        options = options.including(ErrorAttributeOptions.Include.MESSAGE);
        if (this.errorProperties.isIncludeException()) {
            options = options.including(ErrorAttributeOptions.Include.EXCEPTION);
        }
        options = isIncludePath(request) ? options.including(ErrorAttributeOptions.Include.PATH) : options.excluding(ErrorAttributeOptions.Include.PATH);
        return options;
    }



    private boolean isIncludePath(HttpServletRequest request) {
        return switch (this.errorProperties.getIncludePath()) {
            case ALWAYS -> true;
            case ON_PARAM -> getPathParameter(request);
            case NEVER -> false;
        };
    }

    public String getErrorPath() {
        return this.errorProperties.getPath();
    }

}
