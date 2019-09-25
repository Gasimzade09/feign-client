package com.feign.client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "data", url = "${feign.client.url}")
public interface BookClient {

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List> getBook();

    @RequestMapping(method = RequestMethod.GET, value = "/{isbn}")
    ResponseEntity<Object> getOne(@PathVariable("isbn") String isbn);
}
