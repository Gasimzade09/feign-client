package com.feign.client.client.impl;

import com.feign.client.client.BookClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookClientFallback implements BookClient {

    @Override
    public ResponseEntity<List<Object>> getBook() {
        return null;
    }

    @Override
    public ResponseEntity<Object> getOne(String isbn) {
        return null;
    }
}
