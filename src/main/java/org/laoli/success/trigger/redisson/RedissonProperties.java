package org.laoli.success.trigger.redisson;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "redisson")
@Data
@Configuration
public class RedissonProperties {
    private String host = "192.168.31.221";
    private int port = 6379;
    private String password = "redis_DkyYZk";
    private int poolSize = 100;
    private int minIdleSize = 10;
    private int idleTimeout = 10000;
    private int connectTimeout = 10000;
    private int retryAttempts = 3;
    private int retryInterval = 1500;
    private int pingInterval = 10000;
    private boolean keepAlive = true;
}
