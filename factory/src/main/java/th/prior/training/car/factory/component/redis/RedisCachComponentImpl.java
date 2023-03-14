package th.prior.training.car.factory.component.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("redisCachComponentImpl")
@Slf4j
public class RedisCachComponentImpl implements RedisCachComponent{

    private RedisTemplate<String, String> redisTemplate;

    public RedisCachComponentImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void setKeyToRedis(String key, String value, int time, TimeUnit unitType){
        log.info("insertToRedis {}, {}", key, value);
        this.redisTemplate.opsForValue().set(key, value, time, unitType);
    }

    @Override
    public void deleteKeyFromRedis(String key){
        log.info("deleteFromRedis {}", key);
        this.redisTemplate.delete(key);
    }

    @Override
    public String getValueByKey(String key){
        return this.redisTemplate.opsForValue().get(key);
    }
}
