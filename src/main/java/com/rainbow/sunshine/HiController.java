package com.rainbow.sunshine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {


    @PostMapping("/sunshine/hi")
    public ResponseEntity<SlackResponse> postHi() {
        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :rainbow: Nice :sunny: :sunny:");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sunshine/hay")
    public ResponseEntity<SlackResponse> postMessage(@RequestBody SlackBody body) {

        SlackResponse response = new SlackResponse("in_channel", ":rainbow:" + body.text);
        return ResponseEntity.ok(response);
    }

}
