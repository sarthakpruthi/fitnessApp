package com.fitness.app.model.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usage {
    private int promptToken;
    private int completionToken;
    private int totalToken;
}
