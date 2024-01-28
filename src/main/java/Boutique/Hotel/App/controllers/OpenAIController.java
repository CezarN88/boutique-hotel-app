package Boutique.Hotel.App.controllers;

import Boutique.Hotel.App.services.openai.OpenAIService;
import Boutique.Hotel.App.services.openai.OpenAIServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/openai")
public class OpenAIController {

    private final OpenAIService openAiService;

    public OpenAIController(OpenAIService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> getChatResponse(@RequestBody String prompt) {
        return  ResponseEntity.ok(openAiService.getOpenAIResponse(prompt));
    }
}
