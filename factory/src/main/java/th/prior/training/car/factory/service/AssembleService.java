package th.prior.training.car.factory.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.prior.training.car.factory.component.AssembleTransformComponent;
import th.prior.training.car.factory.model.AssembleRequestModel;

@Service
@Slf4j
public class AssembleService {

    private AssembleTransformComponent assembleTransformComponent;

    public AssembleService(AssembleTransformComponent assembleTransformComponent) {
        this.assembleTransformComponent = assembleTransformComponent;
    }

    public void assembleCar(String jsonMessage) throws JsonProcessingException {
        AssembleRequestModel assembleRequestModel = this.assembleTransformComponent.jsonToModel(jsonMessage);
        log.info("assembleACar orderid {}", assembleRequestModel.getOrderId());
        
        try {
            // TODO: 15/11/65  

        }catch (Exception e){
            log.info("assembleACar orderid {} error {}", assembleRequestModel.getOrderId(),e.getMessage());
        }
    }
}
