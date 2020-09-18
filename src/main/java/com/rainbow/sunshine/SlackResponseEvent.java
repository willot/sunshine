package com.rainbow.sunshine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SlackResponseEvent {

    public String text;
    public String channel;
}
