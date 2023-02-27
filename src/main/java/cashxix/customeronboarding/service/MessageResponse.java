package cashxix.customeronboarding.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class MessageResponse {

    @Value("${twillio.username}")
    private String username;

    @Value("${twillio.password}")
    private String password;

    public void send(MultiValueMap<String,String> body) {

        // Set up the Basic Authorization header

        String authHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        // Set up the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", authHeader);

        // Set up the request body as x-www-form-urlencode

        // Set up the HTTP entity with the headers and body
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        // Make the API call using RestTemplate
        String apiUrl = "https://api.twilio.com/2010-04-01/Accounts/AC4003ad7e95eeca7814f0db1b53473e6c/Messages.json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // Print the API response
        String responseBody = responseEntity.getBody();
        System.out.println("API Response: " + responseBody);
    }
}
