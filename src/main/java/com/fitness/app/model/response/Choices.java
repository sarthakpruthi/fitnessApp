package com.fitness.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fitness.app.model.request.Messages;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Choices {

    private int index;
    private Messages message;
    @JsonProperty("finish_reason")
    private String finishReason;
}
