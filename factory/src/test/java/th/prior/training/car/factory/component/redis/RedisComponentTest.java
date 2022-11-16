package th.prior.training.car.factory.component.redis;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RedisComponentTest implements RedisCachComponent{
    @Override
    public void setKeyToRedis(String key, String value, int time, TimeUnit unitType) {
        log.info("insertToRedis {}, {}", key, value);
    }

    @Override
    public void deleteKeyFromRedis(String key) {

    }

    @Override
    public String getValueByKey(String key) {
        return null;
    }
}
