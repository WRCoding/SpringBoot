package com.wlj.springbootcar.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author LB
 * @create 2019-03-09 16:21
 */
public class Book {

    private Integer bookId;  //编号
    @Excel(name = "bookName",orderNum = "0")
    private String bookName;  //书名
    @Excel(name = "bookSprice",orderNum = "1")
    private double bookSprice;  //价格
    @Excel(name = "bookAuthor",orderNum = "2")
    private String bookAuthor;  //作者
    @Excel(name = "bookCount",orderNum = "3")
    private Integer bookCount;  //数量

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookSprice=" + bookSprice +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookCount=" + bookCount +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookSprice() {
        return bookSprice;
    }

    public void setBookSprice(double bookSprice) {
        this.bookSprice = bookSprice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }
}
