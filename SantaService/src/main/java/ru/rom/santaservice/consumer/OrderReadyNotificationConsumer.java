package ru.rom.santaservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.rom.santaservice.dto.NotifyMessageDTO;
import ru.rom.santaservice.service.IStorageService;

@Slf4j //logger
@Component
@RequiredArgsConstructor
public class OrderReadyNotificationConsumer {
    private final ObjectMapper mapper;
    private final IStorageService service;

    @KafkaListener(topics = "${topic.name}")
    public void listenReadyNotification(String message) throws JsonProcessingException {
        log.info("Got presents ready notification! " + message);
        NotifyMessageDTO messageDTO = mapper.readValue(message, NotifyMessageDTO.class);
        service.increasePresentAmount(messageDTO);
    }
}
