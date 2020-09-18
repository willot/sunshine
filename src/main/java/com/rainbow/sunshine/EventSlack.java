package com.rainbow.sunshine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventSlack {

    public String type;
    public String channel;
    public String user;
    public String text;
    public String ts;
    public String event_ts;
    public String channel_type;
}
