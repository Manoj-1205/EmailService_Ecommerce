package dev.manoj.emailservice.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.manoj.emailservice.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumer {
    private ObjectMapper objectMapper;
    @KafkaListener(topics = "sendEmail",
                    groupId = "emailService")
    public void consumeMessage(String message) throws JsonProcessingException {
        UserDTO userDTO = objectMapper.readValue(message, UserDTO.class);
        System.out.println("USER DTO "+userDTO.getEmail());

    }
}
