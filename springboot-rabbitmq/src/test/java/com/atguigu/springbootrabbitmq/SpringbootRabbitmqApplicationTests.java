package com.atguigu.springbootrabbitmq;

import com.atguigu.springbootrabbitmq.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 1.单播（点对点消息）
     */
    @Test
    public void contextLoads() {

        //rabbitTemplate.send();
//        Map<String,Object> map=new HashMap<>();
//        map.put("msg", "hello");
//        map.put("data", Arrays.asList("hello wolrd",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));
    }
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }
    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanoout","",new Book("三国演义","罗贯中"));
    }

    @Test
    public void createExchange(){
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.change"));
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        //amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.change","amqp.haha",null));
        amqpAdmin.removeBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.change","amqp.haha",null));
    }
}

