package com.example.springdemowebbasic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author rival
 * @since 2024-11-19
 */

@RestController
@RequestMapping("/forward-redirect")
public class ForwardAndRedirectController {


    private final String dest = "/forward-redirect/destination";


    @GetMapping("/redirect")
    public ResponseEntity<?> redirect(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",dest);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }


    @GetMapping("/redirect2")
    public void redirect2(HttpServletResponse response) throws IOException {
        response.sendRedirect(dest);
    }

    @GetMapping("/forward")
    public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(dest).forward(request,response);
    }



    @GetMapping("/destination")
    public String destination(){
        return "OK";
    }
}
