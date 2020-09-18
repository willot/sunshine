package com.rainbow.sunshine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SlackSpyBody {

        public String token;
//        public String challenge;
        public String type;
        public EventSlack event;
}
