package com.rainbow.sunshine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HiController {


    @PostMapping("/sunshine/hi")
    public ResponseEntity<SlackResponse> postHi() {
        List emojis = Emoji.getEmoji();
        String everything="";

        for (int i = 0; i < emojis.size(); i++) {
            everything = everything + " " + emojis.get(i);

        }

        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :rainbow: Nice to see you today!!! :sunny: :sunny: Have a great sunny day!! :sunny: :unicorn_face: :fireworks: :pikachu_dancing:" + " " + everything);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sunshine/hay")
    public ResponseEntity<SlackResponse> postMessage(@RequestParam String text, @RequestParam String user_name) {

        SlackResponse response = new SlackResponse("in_channel", ":rainbow:" + text);
        return ResponseEntity.ok(response);
    }

}
