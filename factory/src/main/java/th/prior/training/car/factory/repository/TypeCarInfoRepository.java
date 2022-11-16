package th.prior.training.car.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.prior.training.car.factory.entity.TypeCarInfoEntity;

import java.util.List;

@Repository
public interface TypeCarInfoRepository extends JpaRepository<TypeCarInfoEntity, Integer> {

    List<TypeCarInfoEntity> findAllByTypeGroupAndIsActive(String typeGroup, String isActive);
    List<TypeCarInfoEntity> findAllByIsActive(String isActive);
}
