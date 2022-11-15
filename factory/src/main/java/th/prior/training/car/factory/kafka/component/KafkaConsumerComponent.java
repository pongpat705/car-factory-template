package th.prior.training.car.factory.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumerComponent {


    @KafkaListener(topics = "${app.kafka.topics.is-ready}", groupId = "${app.kafka.groupid}")
    public void ncbResult(@Payload String message) throws Exception {
       log.info("factory got messa got {}", message);
    }
}
