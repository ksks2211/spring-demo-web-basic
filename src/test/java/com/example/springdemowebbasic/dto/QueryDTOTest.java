package com.example.springdemowebbasic.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.AntPathMatcher;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rival
 * @since 2024-11-18
 */
class QueryDTOTest {



    @DisplayName("1. Test Ant Matcher")
    @Test
    void test_1() {
        AntPathMatcher matcher = new AntPathMatcher();
        assertTrue(matcher.match("/api/**","/api/posts"));
        assertTrue(matcher.match("/api/*","/api/posts"));

        assertTrue(matcher.match("/api/**","/api"));

        assertTrue(matcher.match("/api/*","/api/"));



    }


}