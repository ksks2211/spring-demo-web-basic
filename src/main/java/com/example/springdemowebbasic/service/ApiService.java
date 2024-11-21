package com.example.springdemowebbasic.service;

import com.example.springdemowebbasic.dto.LoginDto;
import com.example.springdemowebbasic.dto.QueryDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.function.Function;

/**
 * @author rival
 * @since 2024-11-20
 */

@Service
public class ApiService {

    private final RestClient restClient = RestClient.builder().baseUrl("http://localhost:8080").build();


    public LoginDto getLogin(String username, String password){

        LoginDto body = LoginDto.builder().name(username).password(password).build();
        return restClient.post()
            .uri("/req/body")
            .body(body)
            .retrieve()
            .body(LoginDto.class);

    }





    public QueryDto getQueryDto(QueryDto query){


        Function<UriBuilder, URI> uriBuilderURIFunction = uriBuilder -> uriBuilder
                .path("/req/query")
                .queryParam("page", query.getPage())
                .queryParam("size", query.getSize())
                .queryParam("query",query.getQuery())
                .queryParam("keywords", query.getKeywords())
                .build();

        return restClient.get()
            .uri(uriBuilderURIFunction).retrieve()

            .body(QueryDto.class);
    }



}
