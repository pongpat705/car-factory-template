package th.prior.training.car.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import th.prior.training.car.factory.component.redis.RedisCachComponent;
import th.prior.training.car.factory.component.redis.RedisComponentTest;
import th.prior.training.car.factory.component.schedule.RedisScheduleComponent;
import th.prior.training.car.factory.component.util.TypeCarInfoTransformComponent;
import th.prior.training.car.factory.repository.TypeCarInfoRepository;
import th.prior.training.car.factory.repository.TypeCarInfoRepositoryImplTest;

class FactoryApplicationTests {

	@Test
	void testSetRedis() throws JsonProcessingException {
		TypeCarInfoTransformComponent typeCarInfoTransformComponent = new TypeCarInfoTransformComponent();
		RedisCachComponent redisCachComponent = new RedisComponentTest();
		TypeCarInfoRepository typeCarInfoRepository = new TypeCarInfoRepositoryImplTest();
		RedisScheduleComponent redisScheduleComponent
				= new RedisScheduleComponent(typeCarInfoRepository
				, typeCarInfoTransformComponent
				, redisCachComponent);

		redisScheduleComponent.startUp();
	}

}
