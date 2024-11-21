package com.example.springdemowebbasic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * @author rival
 * @since 2024-11-19
 */


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ErrorResBody {

    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private ZonedDateTime timestamp = ZonedDateTime.now();

    private Integer status;
    private String error;
    private String message;
    private String path;
}
