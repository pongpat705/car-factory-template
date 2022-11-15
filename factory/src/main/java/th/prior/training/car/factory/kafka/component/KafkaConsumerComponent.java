package th.prior.training.car.factory.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.service.AssembleService;

@Slf4j
@Component
public class KafkaConsumerComponent {

    private AssembleService assembleService;

    public KafkaConsumerComponent(AssembleService assembleService) {
        this.assembleService = assembleService;
    }

    @KafkaListener(topics = "${app.kafka.topics.is-ready}", groupId = "${app.kafka.groupid}")
    public void ncbResult(@Payload String message) throws Exception {
       log.info("factory got messa got {}", message);
       this.assembleService.assembleCar(message);
    }
}
