package com.feign.client.controller;

import com.feign.client.client.BookClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {
    private final BookClient bookClient;

    public FeignController(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @GetMapping(path = "/all")
    ResponseEntity<List> getWeather() {
        return ResponseEntity.ok(bookClient.getBook().getBody());
    }

    @GetMapping(value = "/{bookIsbn}")
    ResponseEntity<Object> getByIsbn(@PathVariable String bookIsbn){
        return ResponseEntity.ok(bookClient.getOne(bookIsbn).getBody());
    }
}