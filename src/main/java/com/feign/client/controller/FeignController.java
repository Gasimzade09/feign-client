package com.feign.client.controller;

import com.feign.client.client.BookClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Import(FeignClientsConfiguration.class)
public class FeignController {
    @Autowired
    private BookClient bookClient;


//    @GetMapping(path = "/all")
//    ResponseEntity<List> getWeather() {
//        return ResponseEntity.ok(bookClient.getBook().getBody());
//    }

    @GetMapping(value = "/")
    ResponseEntity<Object> getByIsbn() {
        return ResponseEntity.ok(bookClient.getOne(URI.create("http://localhost:8081/api/books")));
    }
}