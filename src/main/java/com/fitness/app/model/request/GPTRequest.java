package com.fitness.app.model.request;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GPTRequest {
    private String model;
    private List<Messages> messages;
}
