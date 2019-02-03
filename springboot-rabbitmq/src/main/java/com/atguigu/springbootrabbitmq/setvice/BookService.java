package com.atguigu.springbootrabbitmq.setvice;

import com.atguigu.springbootrabbitmq.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author li
 * 2019/2/2 16:49
 * version 1.0
 */
@Service
public class BookService {
    @RabbitListener(queues = "atguigu.news")
    public void revice(Book book){
        System.out.println(book);
    }
    @RabbitListener(queues = "gulixueyuan.news")
    public void receive(Message message){
        System.out.println(message.getBody().getClass());
        System.out.println(message.getMessageProperties().getHeaders());
    }
}
