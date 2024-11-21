package com.example.springdemowebbasic.controller;

import com.example.springdemowebbasic.exception.CustomBadRequestException;
import com.example.springdemowebbasic.properties.AppBasicEnvProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rival
 * @since 2024-11-09
 */

@RestController
@RequestMapping(value="/basic", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Log4j2
public class BasicEnvController {


    @Value("${app.name:defaultAppName}")
    private String appName;

    @Value("${app.version}")
    private int appVersion;


    @Value("${app.some-key}")
    private String appSomeKey;

    @Value("#{'${app.list}'.split(',')}")
    private List<String> appList;



    private final AppBasicEnvProperties properties;


    @GetMapping(value = "")
    public Map<String, String> getMessage(){
        var res = new HashMap<String,String>();
        res.put("message", "Hello World!");
        return res;
    }



    // env from application.yml
    @GetMapping(value="/app-env")
    public Map<String, Object> getEnv(){
        var res = new HashMap<String, Object>();

        res.put("version", appVersion);
        res.put("fruits", properties.getFruits());
        res.put("name", appName);
        res.put("key",appSomeKey);
        res.put("list", appList);

        return res;
    }


    @Value("#{systemProperties['user.home']}")
    private String userHome;

    @Value("#{environment['spring.profiles.active']}")
    private String profileActive;

    @Value("#{exampleService.message}")
    private String messageFromBean;




    @Value("#{exampleService.generateRandInt()}")
    private Integer randomInt;


    // from bean, system properties, system environment
    @GetMapping(value="/variables")
    public Map<String, Object> getVariables(){

        var res = new HashMap<String,Object>();

        res.put("user.home", userHome);

        res.put("message", messageFromBean);

        res.put("random int",  randomInt);

        res.put("profile", profileActive);

        return res;
    }


    @GetMapping(value="/err")
    public void error(){
        throw new RuntimeException("Exception Occurred!");
    }


    @GetMapping(value="/err-custom")
    public void customError(){
        throw new CustomBadRequestException("Bad Request", "Some Field");
    }




}
