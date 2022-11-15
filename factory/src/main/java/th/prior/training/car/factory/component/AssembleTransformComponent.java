package th.prior.training.car.factory.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.model.AssembleRequestModel;

@Component
public class AssembleTransformComponent {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String modelToJson(AssembleRequestModel assembleRequestModel) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(assembleRequestModel);
    }

    public AssembleRequestModel jsonToModel(String json) throws JsonProcessingException {
        AssembleRequestModel result = this.objectMapper.readValue(json, AssembleRequestModel.class);
        return result;
    }
}
