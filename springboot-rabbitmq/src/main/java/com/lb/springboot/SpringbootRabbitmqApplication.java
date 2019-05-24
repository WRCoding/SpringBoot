package com.lb.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1.RabbitAutoConfiguration
 * 2.rabbitConnectionFactory连接工厂，通过RabbitProperties获得rabbitmq的配置
 * 3.RabbitTemplate给Rabbitmq发送和接收消息
 * AmqpAdmin，管理rabbitmq组件
 */
@EnableRabbit//开启基于注解的rabbitmq
@SpringBootApplication
public class SpringbootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqApplication.class, args);
    }

}
