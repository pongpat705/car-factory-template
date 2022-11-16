package th.prior.training.car.factory.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface BaseTransformComponent<M,E>{

    public M transFormEntityToModel(E e);

    public E transFormModelToEntity(M m);

    public void updateEntityByModel(E e, M m);

    public String modelToJson(M m) throws JsonProcessingException;

    public M jsonToModel(String json) throws JsonProcessingException;
}
