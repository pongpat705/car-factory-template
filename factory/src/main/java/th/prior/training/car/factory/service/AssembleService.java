package th.prior.training.car.factory.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import th.prior.training.car.factory.component.redis.RedisCachComponent;
import th.prior.training.car.factory.component.util.AssembleTransformComponent;
import th.prior.training.car.factory.component.util.TypeCarInfoTransformComponent;
import th.prior.training.car.factory.model.AssembleRequestModel;
import th.prior.training.car.factory.model.TypeCarInfoModel;

import java.util.List;

@Service
@Slf4j
public class AssembleService {

    private AssembleTransformComponent assembleTransformComponent;
    private RedisCachComponent redisCachComponent;
    private TypeCarInfoTransformComponent typeCarInfoTransformComponent;

    public AssembleService(AssembleTransformComponent assembleTransformComponent
            , @Qualifier("redisCachComponentImpl") RedisCachComponent redisCachComponent
            , TypeCarInfoTransformComponent typeCarInfoTransformComponent) {
        this.assembleTransformComponent = assembleTransformComponent;
        this.redisCachComponent = redisCachComponent;
        this.typeCarInfoTransformComponent = typeCarInfoTransformComponent;
    }

    public void assembleCar(String jsonMessage) throws JsonProcessingException {
        AssembleRequestModel assembleRequestModel = this.assembleTransformComponent.jsonToModel(jsonMessage);
        log.info("assembleACar orderid {}", assembleRequestModel.getOrderId());
        
        try {
            // TODO: 15/11/65
            List<TypeCarInfoModel> typeCarInfoModels = this.typeCarInfoTransformComponent
                    .jsonToModelList(this.redisCachComponent.getValueByKey(assembleRequestModel.getOrderCarType()));



        }catch (Exception e){
            log.info("assembleACar orderid {} error {}", assembleRequestModel.getOrderId(),e.getMessage());
        }
    }
}
