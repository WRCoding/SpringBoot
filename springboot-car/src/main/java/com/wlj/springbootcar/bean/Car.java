package com.wlj.springbootcar.bean;

/**
 * @author LB
 * @create 2019-03-09 16:22
 */
public class Car {
    private Book book;  //书
    private Integer number; // 购买数量

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "book=" + book +
                ", number=" + number +
                '}';
    }
}
