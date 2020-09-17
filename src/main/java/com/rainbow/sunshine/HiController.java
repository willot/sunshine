package com.rainbow.sunshine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {


    @PostMapping("/sunshine/hi")
    public ResponseEntity<String> postHi() {
        return ResponseEntity.ok(
                "{\"response_type\":\"in_channel\",\"text\":\":rainbow: :rainbow: Nice :sunny: :sunny:\" }"
                );
    }

    @PostMapping("/sunshine/hay")
    public ResponseEntity<String> postMessage() {
        return ResponseEntity.ok(
                "{\"response_type\":\"in_channel\",\"channel\":\"@vwillot\",\"text\":\":rainbow: :rainbow: Nice :sunny: :sunny:\" }"
        );
    }
}
