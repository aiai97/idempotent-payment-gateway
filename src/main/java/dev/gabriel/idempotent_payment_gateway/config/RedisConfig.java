package dev.gabriel.idempotent_payment_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
//RedisConnectionFactory	How does the application establish a connection to Redis?
//StringRedisSerializer	How do we serialize Redis keys into human-readable strings?
//GenericJackson2JsonRedisSerializer	How do we convert Java objects into JSON when storing them in Redis, and deserialize JSON back into Java objects when retrieving them?
//account:1001	Account
//transaction:T001	Transaction
//payment:lock:001	String
//balance:1001	BigDecimal