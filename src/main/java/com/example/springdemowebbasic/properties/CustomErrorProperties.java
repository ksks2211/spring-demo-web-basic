package com.example.springdemowebbasic.properties;

import lombok.*;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.stereotype.Component;

/**
 * @author rival
 * @since 2024-11-19
 */


@AllArgsConstructor
@Getter
@Setter
@Component
public class CustomErrorProperties extends ErrorProperties {
}
