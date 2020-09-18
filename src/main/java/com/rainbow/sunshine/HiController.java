package com.rainbow.sunshine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class HiController {


    @PostMapping("/sunshine/hi")
    public ResponseEntity<SlackResponse> postHi() {
        List emojis = Emoji.getEmoji();
        String everything="";

        for (int i = 0; i < emojis.size(); i++) {
            everything = everything + " " + emojis.get(i);

        }

        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :rainbow: Nice to see you today!!! :sunny: :sunny: Have a great sunny day!! :sunny: :unicorn_face: :fireworks: :pikachu_dancing:");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sunshine/hay")
    public ResponseEntity<SlackResponse> postMessage(@RequestParam String text, @RequestParam String user_name) {
        List emojis = Emoji.getEmoji();
        Random random = new Random();



        String glitterString = "";
        String[] textArray = text.split(" ");
        for (String word: textArray) {
            int index = random.nextInt(emojis.size());
            glitterString = glitterString + " " + emojis.get(index) + word + " " +emojis.get(index);
        }


        SlackResponse response = new SlackResponse("in_channel", user_name + "want to know how you are doing?" + glitterString );
        return ResponseEntity.ok(response);
    }

}
