package th.prior.training.car.showroom.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import th.prior.training.car.showroom.component.AssembleTransformComponent;
import th.prior.training.car.showroom.component.BaseAPIComponent;
import th.prior.training.car.showroom.entity.BuyerOrderEntity;
import th.prior.training.car.showroom.kafka.component.KafkaProducerComponent;
import th.prior.training.car.showroom.model.AssembleRequestModel;
import th.prior.training.car.showroom.model.ProduceableRequestModel;
import th.prior.training.car.showroom.model.ProduceableResponseModel;
import th.prior.training.car.showroom.model.ResponseModel;
import th.prior.training.car.showroom.repository.BuyerOrderRepository;

import java.util.Optional;

@Slf4j
@Service
public class ShowroomService {

    private BaseAPIComponent<ProduceableRequestModel, ProduceableResponseModel> produceableApiComponent;
    private KafkaProducerComponent kafkaProducerComponent;
    private BuyerOrderRepository buyerOrderRepository;
    private AssembleTransformComponent assembleTransformComponent;

    @Value("${app.kafka.topics.is-ready}")
    private String isReadyTopic;

    public ShowroomService(BaseAPIComponent<ProduceableRequestModel, ProduceableResponseModel> produceableApiComponent, KafkaProducerComponent kafkaProducerComponent, BuyerOrderRepository buyerOrderRepository, AssembleTransformComponent assembleTransformComponent) {
        this.produceableApiComponent = produceableApiComponent;
        this.kafkaProducerComponent = kafkaProducerComponent;
        this.buyerOrderRepository = buyerOrderRepository;
        this.assembleTransformComponent = assembleTransformComponent;
    }

    public ResponseModel<Void> assembleACar(String orderId){
        ResponseModel<Void> result = new ResponseModel<>();
        result.setStatus(500);
        log.info("assembleACar orderid {}", orderId);
        try {
            int orderIdInt = Integer.parseInt(orderId);

            Optional<BuyerOrderEntity> buyerOrderEntityOptional = this.buyerOrderRepository
                    .findByOrderIdAndIsActive(orderIdInt, "Y");
            if(buyerOrderEntityOptional.isPresent()){
                BuyerOrderEntity buyerOrderEntity = buyerOrderEntityOptional.get();
                AssembleRequestModel assembleRequestModel = new AssembleRequestModel();
                assembleRequestModel.setBuyerName(buyerOrderEntity.getBuyerName());
                assembleRequestModel.setOrderCarType(buyerOrderEntity.getOrderCarType());
                assembleRequestModel.setOrderId(buyerOrderEntity.getOrderId());

                this.kafkaProducerComponent
                        .send(this.assembleTransformComponent.modelToJson(assembleRequestModel)
                                , this.isReadyTopic);

                buyerOrderEntity.setOrderStatus("assembling");
                this.buyerOrderRepository.save(buyerOrderEntity);
                result.setStatus(200);
                result.setDescription("sent assembling order to factory");
            } else {
                result.setStatus(404);
                result.setDescription("assembleACar order not found ");
            }

        }catch (Exception e){
            log.info("assembleACar orderid {} error {}", orderId, e.getMessage());
            result.setDescription("assembleACar error "+e.getMessage());
        }

        return result;
    }




    public boolean shouldTellBuyer(ProduceableResponseModel produceableResponseModel){
        boolean result = false;

        if(produceableResponseModel.isProduce()){
            result = true;
        }

        return result;
    }
}
