package kr.co.kafkapubtestrs.controller;

import kr.co.kafkapubtestrs.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/publish")
    public ResponseEntity<Void> sendMessage(String message) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok().build();
    }

}
