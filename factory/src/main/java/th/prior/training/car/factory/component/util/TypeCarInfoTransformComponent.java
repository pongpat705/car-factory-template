package th.prior.training.car.factory.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.entity.TypeCarInfoEntity;
import th.prior.training.car.factory.model.TypeCarInfoModel;

import java.util.List;

@Component
public class TypeCarInfoTransformComponent implements BaseTransformComponent<TypeCarInfoModel, TypeCarInfoEntity>{
    private ObjectMapper objectMapper = new ObjectMapper();

    public TypeCarInfoTransformComponent() {
        this.objectMapper = objectMapper;
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public TypeCarInfoModel transFormEntityToModel(TypeCarInfoEntity typeCarInfoEntity) {
        TypeCarInfoModel a = new TypeCarInfoModel();
        a.setTypeAmount(typeCarInfoEntity.getTypeAmount());
        a.setTypeId(typeCarInfoEntity.getTypeId());
        a.setTypeGroup(typeCarInfoEntity.getTypeGroup());
        a.setTypePart(typeCarInfoEntity.getTypePart());
        a.setIsActive(typeCarInfoEntity.getIsActive());
        a.setTypeCreateDate(typeCarInfoEntity.getTypeCreateDate());
        return a;
    }

    @Override
    public TypeCarInfoEntity transFormModelToEntity(TypeCarInfoModel typeCarInfoModel) {
        return null;
    }

    @Override
    public void updateEntityByModel(TypeCarInfoEntity typeCarInfoEntity, TypeCarInfoModel typeCarInfoModel) {

    }

    @Override
    public String modelToJson(TypeCarInfoModel typeCarInfoModel) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(typeCarInfoModel);
    }

    @Override
    public TypeCarInfoModel jsonToModel(String json) throws JsonProcessingException {
        return this.objectMapper.readValue(json, TypeCarInfoModel.class);
    }

    public List<TypeCarInfoModel> jsonToModelList(String json) throws JsonProcessingException {
        return this.objectMapper.readValue(json, new TypeReference<List<TypeCarInfoModel>>(){});
    }

    public String modelListTojson(Object o) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(o);
    }
}
