package th.prior.training.car.factory.repository;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import th.prior.training.car.factory.entity.TypeCarInfoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TypeCarInfoRepositoryImplTest implements TypeCarInfoRepository{
    @Override
    public List<TypeCarInfoEntity> findAllByTypeGroupAndIsActive(String typeGroup, String isActive) {
        return null;
    }

    @Override
    public List<TypeCarInfoEntity> findAllByIsActive(String isActive) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.registerModule(new JavaTimeModule());
        String data = "[\n  {\n    \"type_id\": 1,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"wheel\",\n    \"type_amount\": 5,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  },\n  {\n    \"type_id\": 2,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"engine\",\n    \"type_amount\": 1,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  },\n  {\n    \"type_id\": 3,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"transmission\",\n    \"type_amount\": 1,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  },\n  {\n    \"type_id\": 4,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"windshield\",\n    \"type_amount\": 6,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  },\n  {\n    \"type_id\": 5,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"tyre\",\n    \"type_amount\": 5,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  },\n  {\n    \"type_id\": 6,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"break\",\n    \"type_amount\": 4,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  },\n  {\n    \"type_id\": 7,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"headlight\",\n    \"type_amount\": 2,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  },\n  {\n    \"type_id\": 8,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"taillight\",\n    \"type_amount\": 2,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  },\n  {\n    \"type_id\": 9,\n    \"type_group\": \"car_model_a\",\n    \"type_part\": \"turn-light\",\n    \"type_amount\": 4,\n    \"type_create_date\": \"2022-11-16 13:48:39\",\n    \"is_active\": \"Y\"\n  }\n]";
        List<TypeCarInfoEntity> typeCarInfoEntities = new ArrayList<>();
        try {
            typeCarInfoEntities = mapper.readValue(data, new TypeReference<List<TypeCarInfoEntity>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return typeCarInfoEntities;
    }

    @Override
    public List<TypeCarInfoEntity> findAll() {
        return null;
    }

    @Override
    public List<TypeCarInfoEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TypeCarInfoEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TypeCarInfoEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(TypeCarInfoEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends TypeCarInfoEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TypeCarInfoEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TypeCarInfoEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TypeCarInfoEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends TypeCarInfoEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TypeCarInfoEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<TypeCarInfoEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TypeCarInfoEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public TypeCarInfoEntity getById(Integer integer) {
        return null;
    }

    @Override
    public TypeCarInfoEntity getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends TypeCarInfoEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TypeCarInfoEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TypeCarInfoEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TypeCarInfoEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TypeCarInfoEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TypeCarInfoEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TypeCarInfoEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
