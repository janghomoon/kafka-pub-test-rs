package kr.co.kafkapubtestrs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC_NAME = "test-jhm-topic";


    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        log.info("✅ 메시지 발행됨: {}", message);
    }

    public void sendMessage(String message, int partition) {
        kafkaTemplate.send(TOPIC_NAME, partition, null, message);
        kafkaTemplate.send(TOPIC_NAME, message);
        log.info("✅ 메시지 발행됨: {}", message);
    }

}
