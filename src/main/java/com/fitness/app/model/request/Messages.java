package com.fitness.app.model.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Messages {
    private String role;
    private String content;
}
