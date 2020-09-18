package com.rainbow.sunshine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class HiController {


    @PostMapping("/sunshine/hi")
    public ResponseEntity<SlackResponse> postHi() {
        List emojis = Emoji.getEmoji();

        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :rainbow: Nice to see you today!!! :sunny: :sunny: Have a great sunny day!! :sunny: :unicorn_face: :beach_with_umbrella: :pikachu_dancing:");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sunshine/hay")
    public ResponseEntity<SlackResponse> postMessage(@RequestParam String text, @RequestParam String user_id) {
        List emojis = Emoji.getEmoji();
        Random random = new Random();

        String glitterString = "";
        String[] textArray = text.split(" ");
        int exclamationPoints = 0;
        for (String word : textArray) {
            int index = random.nextInt(emojis.size());
            glitterString = glitterString + " " + emojis.get(index) + " " + word.toUpperCase() + " " + emojis.get(index);
            exclamationPoints++;
        }

        if (exclamationPoints > 1) {
            glitterString = glitterString + "!!!";
        } else {
            glitterString = "";
        }

        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :sunny: " + "<@" + user_id + ">" + " :rainbow: :sunny: " +
                "want to know how you are doing?" + ":rainbow: :sunny: " + "\n" + glitterString);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/sunshine/welcome")
    public ResponseEntity<SlackResponse> postWelcome(@RequestParam String user_id) {
        List emojis = Emoji.getEmoji();
        Random random = new Random();

        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :sunny: " + "<@" + user_id + ">" +
                " :rainbow: :sunny: \n" + emojis.get(random.nextInt(emojis.size())) + " " + emojis.get(random.nextInt(emojis.size())) +
                " " + emojis.get(random.nextInt(emojis.size())) + " " + "!!!WELCOME TO THE TEAM!!!" + emojis.get(random.nextInt(emojis.size())) +
                " " + emojis.get(random.nextInt(emojis.size())) + " " + emojis.get(random.nextInt(emojis.size())) + " ");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sunshine/spy")
    public ResponseEntity<SlackResponse> postSpy(@RequestBody String body) {
        List emojis = Emoji.getEmoji();

//        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :rainbow: Nice to see you today!!! :sunny: :sunny: Have a great sunny day!! :sunny: :unicorn_face: :beach_with_umbrella: :pikachu_dancing:");
        return ResponseEntity.ok().build();
    }
}
