package com.example.springdemowebbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rival
 * @since 2024-11-11
 */

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class QueryDto {

    private int page;
    private int size;
    @Builder.Default
    private List<String> keywords = new ArrayList<>();
    private String query;
}
