package com.example.springdemowebbasic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rival
 * @since 2024-11-18
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
public @interface InterceptQuery {
    String value();
}
