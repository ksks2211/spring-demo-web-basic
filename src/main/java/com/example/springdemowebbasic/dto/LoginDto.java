package com.example.springdemowebbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rival
 * @since 2024-11-19
 */


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {


    private String name;
    private String password;
}
