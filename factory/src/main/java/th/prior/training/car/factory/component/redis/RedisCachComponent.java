package th.prior.training.car.factory.component.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public interface RedisCachComponent {

    public void setKeyToRedis(String key, String value, int time, TimeUnit unitType);

    public void deleteKeyFromRedis(String key);
    public String getValueByKey(String key);
}
