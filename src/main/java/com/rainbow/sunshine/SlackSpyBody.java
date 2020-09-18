package com.rainbow.sunshine;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class SlackSpyBody {

        public String token;
        public String team_id;
        public String api_app_id;
        public EventSlack event;
        public String type;
        public ArrayList<String> authed_teams;
        public String event_id;
        public String event_time;
}
