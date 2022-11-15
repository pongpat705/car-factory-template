package th.prior.training.car.showroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.prior.training.car.showroom.entity.BuyerOrderEntity;

import java.util.Optional;

@Repository
public interface BuyerOrderRepository extends JpaRepository<BuyerOrderEntity, Integer> {

    Optional<BuyerOrderEntity> findByOrderIdAndIsActive(int orderId, String isActive);
}
