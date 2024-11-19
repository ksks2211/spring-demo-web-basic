package com.example.springdemowebbasic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rival
 * @since 2024-11-11
 */


@RestController
@RequestMapping(value="/res", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Log4j2
public class HandleResController {
}
