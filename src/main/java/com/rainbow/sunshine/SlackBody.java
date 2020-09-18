package com.rainbow.sunshine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SlackBody {

    public String token;
    public String team_id;
    public String team_domain;
    public String enterprise_id;
    public String enterprise_name;
    public String channel_id;
    public String channel_name;
    public String user_id;
    public String user_name;
    public String command;
    public String text;
    public String response_url;
    public String trigger_id;
    public String api_app_id;

}
