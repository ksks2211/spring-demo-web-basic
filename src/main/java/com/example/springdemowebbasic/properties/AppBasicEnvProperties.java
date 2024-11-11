package com.example.springdemowebbasic.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rival
 * @since 2024-11-09
 */

@Component
@ConfigurationProperties(prefix="basket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppBasicEnvProperties {
    private List<String> fruits;
}
