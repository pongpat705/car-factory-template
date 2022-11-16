package th.prior.training.car.factory.component.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.component.redis.RedisCachComponent;
import th.prior.training.car.factory.component.util.TypeCarInfoTransformComponent;
import th.prior.training.car.factory.entity.TypeCarInfoEntity;
import th.prior.training.car.factory.model.TypeCarInfoModel;
import th.prior.training.car.factory.repository.TypeCarInfoRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RedisScheduleComponent{

    private TypeCarInfoRepository typeCarInfoRepository;
    private TypeCarInfoTransformComponent typeCarInfoTransformComponent;
    private RedisCachComponent redisCachComponent;

    public RedisScheduleComponent(TypeCarInfoRepository typeCarInfoRepository
            , TypeCarInfoTransformComponent typeCarInfoTransformComponent
            , @Qualifier("redisCachComponentImpl") RedisCachComponent redisCachComponent) {
        this.typeCarInfoRepository = typeCarInfoRepository;
        this.typeCarInfoTransformComponent = typeCarInfoTransformComponent;
        this.redisCachComponent = redisCachComponent;
    }


    @Scheduled(cron = "0 0 6 * * *")
    public void updateModelTypesToRedis() throws JsonProcessingException {
        this.initToRedis();
    }

    @PostConstruct
    public void startUp() throws JsonProcessingException {
        this.initToRedis();
    }

    private void initToRedis() throws JsonProcessingException {
        List<TypeCarInfoEntity> typeCarInfoEntities = this.typeCarInfoRepository.findAllByIsActive("Y");
        List<TypeCarInfoModel> typeCarInfoModels = typeCarInfoEntities
                .stream().map(typeCarInfoEntity ->
                        this.typeCarInfoTransformComponent.transFormEntityToModel(typeCarInfoEntity))
                .collect(Collectors.toList());
        Map<String, List<TypeCarInfoModel>> map = new HashMap<>();
        for (TypeCarInfoModel typeCarInfoModel : typeCarInfoModels) {
            if (map.containsKey(typeCarInfoModel.getTypeGroup())){
                List<TypeCarInfoModel> a = map.get(typeCarInfoModel.getTypeGroup());
                a.add(typeCarInfoModel);
            } else {
                List<TypeCarInfoModel> a = new ArrayList<>();
                a.add(typeCarInfoModel);
                map.put(typeCarInfoModel.getTypeGroup(), a);
            }
        }

        for (String keySet: map.keySet()) {

            String json = this.typeCarInfoTransformComponent.modelListTojson(map.get(keySet));

            this.redisCachComponent.setKeyToRedis(keySet, json, 24, TimeUnit.MINUTES);
        }


    }
}
