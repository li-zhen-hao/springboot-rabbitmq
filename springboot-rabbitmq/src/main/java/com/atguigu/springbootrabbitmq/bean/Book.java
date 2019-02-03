package com.atguigu.springbootrabbitmq.bean;

import lombok.Data;

/**
 * @author li
 * 2019/2/2 3:52
 * version 1.0
 */
@Data
public class Book {
    private String bookName;
    private String author;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }
}
