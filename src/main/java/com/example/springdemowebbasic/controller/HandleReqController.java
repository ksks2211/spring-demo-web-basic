package com.example.springdemowebbasic.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rival
 * @since 2024-11-11
 */


@RestController
@RequestMapping(value="/req", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class HandleReqController {

    @GetMapping(value="/read-header")
    public Map<String,Object> getReqInfo(HttpServletRequest request){

        var res = new HashMap<String,Object>();


        String ipAddress = request.getHeader("X-Forwarded-For");
        String userAgent = request.getHeader("User-Agent");



        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }


        res.put("Ip", ipAddress);

        res.put("agent", userAgent);

        return res;

    }


}
