package com.mytask.library.ClientInterface;

import com.mytask.library.DTO.PopularBooksResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "popularbooks",url = "https://openlibrary.org/search/authors.json")
public interface PopularBooks {

    @GetMapping
    public ResponseEntity<PopularBooksResponse> getPopularBooks(@RequestParam String q);


}
