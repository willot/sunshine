package com.rainbow.sunshine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

@RestController
public class HiController {

    @Value("${bearerToken}")
    private String bearerToken;

    @PostMapping("/sunshine/hi")
    public ResponseEntity<SlackResponse> postHi() {
        List emojis = Emoji.getEmoji();

        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :rainbow: Nice to see you today!!! :sunny: :sunny: Have a great sunny day!! :sunny: :unicorn_face: :beach_with_umbrella: :pikachu_dancing:");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sunshine/hay")
    public ResponseEntity<SlackResponse> postMessage(@RequestParam String text, @RequestParam String user_id) {
        SlackResponse makeHappyString = getSlackResponse(text);
        return ResponseEntity.ok(makeHappyString);
    }

    @PostMapping("/sunshine/ford")
    public ResponseEntity<SlackResponse> postMessage(@RequestParam String text) {
        List emojis = FordEmoji.getFordEmoji();
        Random random = new Random();

        String fordifiedString = "";
        String[] textArray = text.split(" ");
        for (String word : textArray) {
            int index = random.nextInt(emojis.size());
            fordifiedString = fordifiedString + " " + emojis.get(index) + " " + word.toUpperCase() + " " + emojis.get(index);
        }


        SlackResponse response = new SlackResponse("in_channel", ":ford-6583: :ford_all_fast: " + fordifiedString + " :ford-6583: :ford_all_fast: ");
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
    public ResponseEntity<String> postSpy(@RequestBody SlackSpyBody body) throws URISyntaxException {
        List emojis = Emoji.getEmoji();
        System.out.println("Body " + body);
        System.out.println("Event " + body.event);
        System.out.println("Event " + body.event.text);
        System.out.println("Event " + body.event.channel);
        System.out.println("token " + body.token);

        if (body.event.text.contains("Vianney")) {
            System.out.println("contains Vianney");
            responseToSlack(body);

        }
        return ResponseEntity.ok().build();
//        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :rainbow: Nice to see you today!!! :sunny: :sunny: Have a great sunny day!! :sunny: :unicorn_face: :beach_with_umbrella: :pikachu_dancing:");
    }

    public SlackResponse getSlackResponse(String text) {
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

        if (exclamationPoints >= 1) {
            glitterString = glitterString + "!!!";
        } else {
            glitterString = "";
        }

        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :sunny: " + glitterString + " :rainbow: :sunny: ");
        return response;
    }

    private void responseToSlack(SlackSpyBody body) throws URISyntaxException {
        System.out.println(body);
        System.out.println("tok " + bearerToken);

        final String uri = "http://slack.com/api/chat.postMessage?" + "channel=" + body.event.channel +
                "&text=bobobobob";
//                + body.event.text;

        System.out.println("url " + uri);
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);
        HttpEntity<Object> request = new HttpEntity<>("", headers);

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Object> response = restTemplate.exchange(new URI(uri), HttpMethod.GET, request, Object.class);
            System.out.println("*********");
            System.out.println(response.getBody());
            System.out.println(response);
            System.out.println("#########");
        } catch (Exception e){
            System.out.println(e);

        }

        System.out.println(new URI(uri));
    }
}
