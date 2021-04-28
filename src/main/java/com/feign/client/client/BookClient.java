package com.feign.client.client;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@FeignClient(name = "data", url = "/")
public interface BookClient {

    @RequestMapping(method = RequestMethod.GET)
    List<Object> getBook();

    @GetMapping
    String getOne(URI uri);
}