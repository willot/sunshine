package com.rainbow.sunshine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {


    @PostMapping("/sunshine/hi")
    public ResponseEntity<String> postHi() {
        return ResponseEntity.ok(
                "{\"response_type\":\"in_channel\",\"text\":\"Nice\" }"
                );
    }
}
