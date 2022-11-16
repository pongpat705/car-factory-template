package th.prior.training.car.factory.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.model.AssembleRequestModel;

@Component
public class AssembleTransformComponent implements BaseTransformComponent<AssembleRequestModel, Void>{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public AssembleRequestModel transFormEntityToModel(Void unused) {
        return null;
    }

    @Override
    public Void transFormModelToEntity(AssembleRequestModel assembleRequestModel) {
        return null;
    }

    @Override
    public void updateEntityByModel(Void unused, AssembleRequestModel assembleRequestModel) {

    }

    @Override
    public String modelToJson(AssembleRequestModel assembleRequestModel) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(assembleRequestModel);
    }
    @Override
    public AssembleRequestModel jsonToModel(String json) throws JsonProcessingException {
        AssembleRequestModel result = this.objectMapper.readValue(json, AssembleRequestModel.class);
        return result;
    }






}
