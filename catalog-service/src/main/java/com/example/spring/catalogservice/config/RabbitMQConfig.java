package com.example.spring.catalogservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "polar.admin";
    public static final String ROUTING_KEY = "catalog.create";
    public static final String QUEUE_NAME = "polar.admin.catalog";
    public static final String DEAD_LETTER_QUEUE_NAME = "polar.admin.catalog.dlq";

    @Bean
    public DirectExchange catalogExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue catalogQueue() {
        return QueueBuilder.durable(QUEUE_NAME)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", DEAD_LETTER_QUEUE_NAME)
                .build();
    }

    @Bean
    public Binding binding(Queue catalogQueue, DirectExchange catalogExchange) {
        return BindingBuilder
                .bind(catalogQueue)
                .to(catalogExchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange("dead-letter-exchange");
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DEAD_LETTER_QUEUE_NAME);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setRetryTemplate(retryTemplate());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        // 최대 재시도 3회
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(3);
        retryTemplate.setRetryPolicy(retryPolicy);

        // 지수 백오프 적용
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(500); // 초기 대기 시간 500ms
        backOffPolicy.setMultiplier(2.0);      // 증가 배율
        backOffPolicy.setMaxInterval(5000);    // 최대 대기 시간 5초
        retryTemplate.setBackOffPolicy(backOffPolicy);

        return retryTemplate;
    }

}
