package th.prior.training.car.showroom.component.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducerComponent {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerComponent(@Qualifier("showroomKafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message, String kafkaTopic) {
        this.kafkaTemplate.send(kafkaTopic, message)
                .addCallback(result -> {
                            log.info("kafka send to {} done {}"
                                    , result.getRecordMetadata().topic()
                                    , result.getProducerRecord().value());
                        }
                        , ex -> {
                            log.info("kafka send exception {}", ex.getMessage());
                        });
    }
}
