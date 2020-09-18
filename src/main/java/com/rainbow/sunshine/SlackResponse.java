package com.rainbow.sunshine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SlackResponse {

    public String response_type;
    public String text;

}
