package com.lb.springboot;

import com.lb.springboot.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 测试单播（direct）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个且定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routingKey ,message );
        //只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routingKey ,object );
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是一个测试消息" );
        map.put("data", Arrays.asList("Hello Rabbitmq",123,true));
        //对象被自动序列化发送
        rabbitTemplate.convertAndSend("exchange.direct", "lb.news",map);

    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("lb.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }
    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","" , new Book("三国演义","罗贯中"));
    }

    /**
     * 根据匹配策略匹配对应的路由键，发送给对应的队列
     */
    @Test
    public void topicExchangeTest(){
        //创建交换器
        amqpAdmin.declareExchange(new TopicExchange("amqpAdmin.topic"));
        //创建消息队列
        amqpAdmin.declareQueue(new Queue("topic.queue"));
        amqpAdmin.declareQueue(new Queue("topic.queue2"));
        //创建绑定规则,#匹配0个或多个单词，*匹配一个单词
        amqpAdmin.declareBinding(new Binding("topic.queue", Binding.DestinationType.QUEUE, "amqpAdmin.topic","topic.*" ,null ));
        amqpAdmin.declareBinding(new Binding("topic.queue2", Binding.DestinationType.QUEUE, "amqpAdmin.topic","topic.#" ,null ));
        //发送消息
        rabbitTemplate.convertAndSend("amqpAdmin.topic","topic.key" , "topic.key");
        rabbitTemplate.convertAndSend("amqpAdmin.topic","topic.lb" , "topic.lb");
        rabbitTemplate.convertAndSend("amqpAdmin.topic","topic.lb.nm" , "topic.lb.nm");
    }
    /**
     * 所有绑定的队列都会收到消息
     */
    @Test
    public void fanoutExchangeTest(){
        //创建交换器
        amqpAdmin.declareExchange(new FanoutExchange("amqpAdmin.fanout"));
        //创建消息队列
        amqpAdmin.declareQueue(new Queue("fanout.queue"));
        amqpAdmin.declareQueue(new Queue("fanout.queue2"));
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("fanout.queue", Binding.DestinationType.QUEUE, "amqpAdmin.fanout","fanout.key" ,null ));
        amqpAdmin.declareBinding(new Binding("fanout.queue2", Binding.DestinationType.QUEUE, "amqpAdmin.fanout","fanout.key2" ,null ));
        //发送消息
        rabbitTemplate.convertAndSend("amqpAdmin.fanout","fanout.key" , "FanoutExchange");
//        rabbitTemplate.convertAndSend("amqpAdmin.fanout","fanout.key2" , "amqpAdmin.key2");

    }
    /**
     * 只有路由键于绑定完全匹配才会发送
     */
    @Test
    public void directExchangeTest(){
        //创建交换器
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        //创建消息队列
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue2"));
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE, "amqpAdmin.exchange","amqpAdmin.key" ,null ));
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue2", Binding.DestinationType.QUEUE, "amqpAdmin.exchange","amqpAdmin.key2" ,null ));
        //发送消息
        rabbitTemplate.convertAndSend("amqpAdmin.exchange","amqpAdmin.key" , "amqpAdmin.key");
        rabbitTemplate.convertAndSend("amqpAdmin.exchange","amqpAdmin.key2" , "amqpAdmin.key2");

    }
}

