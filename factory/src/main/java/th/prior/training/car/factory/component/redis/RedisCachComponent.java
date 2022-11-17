package th.prior.training.car.factory.component.redis;

import java.util.concurrent.TimeUnit;

public interface RedisCachComponent {

    public void setKeyToRedis(String key, String value, int time, TimeUnit unitType);
    public void deleteKeyFromRedis(String key);
    public String getValueByKey(String key);
}
