package th.prior.training.car.showroom.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import th.prior.training.car.showroom.entity.BuyerOrderEntity;
import th.prior.training.car.showroom.model.AssembleRequestModel;

@Component
public class AssembleTransformComponent implements BaseTransformComponent<AssembleRequestModel, BuyerOrderEntity> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public AssembleRequestModel transFormEntityToModel(BuyerOrderEntity buyerOrderEntity) {
        return null;
    }

    @Override
    public BuyerOrderEntity transFormModelToEntity(AssembleRequestModel assembleRequestModel) {
        return null;
    }

    @Override
    public void updateEntityByModel(BuyerOrderEntity buyerOrderEntity, AssembleRequestModel assembleRequestModel) {

    }

    @Override
    public String modelToJson(AssembleRequestModel assembleRequestModel) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(assembleRequestModel);
    }

    @Override
    public AssembleRequestModel jsonToModel(String json) {
        return null;
    }
}
