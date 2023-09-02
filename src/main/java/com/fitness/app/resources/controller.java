package com.fitness.app.resources;

import com.fitness.app.model.ChatBot;
import com.fitness.app.model.request.GPTRequest;
import com.fitness.app.model.request.Messages;
import com.fitness.app.model.response.GPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
public class controller {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/chatBot")
    ResponseEntity<ChatBot> getGPTResponse(@RequestBody ChatBot message){
        GPTRequest gptRequest = GPTRequest.builder().model("gpt-3.5-turbo").messages(List.of(Messages.builder().role("system").content(message.getMessage()).build())).build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth("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");
        HttpEntity<GPTRequest> httpEntity = new HttpEntity<>(gptRequest,httpHeaders);
        ResponseEntity<GPTResponse> response = restTemplate.postForEntity("https://api.openai.com/v1/chat/completions",httpEntity, GPTResponse.class);
        ChatBot messageResponse = ChatBot.builder().message(Objects.requireNonNull(response.getBody()).getChoices().get(0).getMessage().getContent()).build();
        return new ResponseEntity<>(messageResponse, response.getStatusCode());
    }
}
