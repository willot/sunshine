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


//    token=gIkuvaNzQIHg97ATvDxqgjtO
//&team_id=T0001
//&team_domain=example
//&enterprise_id=E0001
//&enterprise_name=Globular%20Construct%20Inc
//&channel_id=C2147483705
//&channel_name=test
//&user_id=U2147483697
//&user_name=Steve
//&command=/weather
//&text=94070
//            &response_url=https://hooks.slack.com/commands/1234/5678
//            &trigger_id=13345224609.738474920.8088930838d88f008e0
//            &api_app_id=A123456
}
