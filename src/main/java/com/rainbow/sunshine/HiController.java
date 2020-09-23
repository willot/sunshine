package com.rainbow.sunshine;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :sunny: " + glitterString + " :rainbow: :sunny: ");
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
    public ResponseEntity<String> postSpy(@RequestBody SlackSpyBody body) {
        List emojis = Emoji.getEmoji();
        System.out.println("Body " + body);
        System.out.println("Event " + body.event);
        System.out.println("Event " + body.event.text);
        System.out.println("Event " + body.event.channel);
        System.out.println("token " + body.token);

        if (body.event.text.contains("Vianney")) {
            System.out.println("contains Vianney");

//            return ResponseEntity.ok(
//                    new SlackResponseEvent(body.event.channel, body.event.text + " HI"));
        }
        return ResponseEntity.ok().build();
//        SlackResponse response = new SlackResponse("in_channel", ":rainbow: :rainbow: Nice to see you today!!! :sunny: :sunny: Have a great sunny day!! :sunny: :unicorn_face: :beach_with_umbrella: :pikachu_dancing:");
    }

    private static void responseToSlack(SlackSpyBody body)
    {
        final String uri = "http://slack.com/api/chat.postMessage?token=" + body.token+ "&channel="+ body.event.channel+
                "&text=" +body.event.text;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri, null, String.class);

        System.out.println(result);
    }
}
