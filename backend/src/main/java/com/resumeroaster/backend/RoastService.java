package com.resumeroaster.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class RoastService {

    @Value("${groq.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, String> roastResume(String resumeText) {

        String prompt = """
                You are a brutally honest, witty, and savage resume roaster.

                Analyze this resume and respond EXACTLY in this format:

                SCORE: <number from 1-10>

                ROAST:
                <funny roast with useful feedback at the end>

                Resume:
                """ + resumeText;

        String url = "https://api.groq.com/openai/v1/chat/completions";

        Map<String, Object> requestBody = Map.of(
                "model", "llama-3.3-70b-versatile",
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", prompt
                        )
                ),
                "temperature", 0.9
        );

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            HttpEntity<Map<String, Object>> entity =
                    new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(url, entity, Map.class);

            List<Map<String, Object>> choices =
                    (List<Map<String, Object>>) response.getBody().get("choices");

            Map<String, Object> message =
                    (Map<String, Object>) choices.get(0).get("message");

            String text = (String) message.get("content");

            String score = "5";
            String roast = text;

            if (text.contains("SCORE:")) {

                for (String line : text.split("\n")) {

                    if (line.startsWith("SCORE:")) {

                        score = line
                                .replace("SCORE:", "")
                                .trim()
                                .replaceAll("[^0-9]", "");

                        break;
                    }
                }

                int roastIndex = text.indexOf("ROAST:");

                if (roastIndex != -1) {
                    roast = text.substring(roastIndex + 6).trim();
                }
            }

            return Map.of(
                    "score", score,
                    "roast", roast
            );

        } catch (Exception e) {

            e.printStackTrace();

            return Map.of(
                    "score", "0",
                    "roast", "Error: " + e.getMessage()
            );
        }
    }
}