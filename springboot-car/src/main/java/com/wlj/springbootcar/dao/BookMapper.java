package com.wlj.springbootcar.dao;

import com.wlj.springbootcar.bean.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author LB
 * @create 2019-04-22 11:08
 */
@Mapper
public interface BookMapper {

    @Select(" select count(*) from book")
    public int  BookSize();

    @Select("select *from book  limit #{startIndex},#{pageSize}")
    public List<Book> Books(Map<String,Integer> map);

    @Select("select *from book where bookName like '%${key}%'")
    public List<Book> searchBook(@Param("key") String key);

    @Select("select *from book where bookId=#{id}")
    public Book getBook(int id);

    @Delete("delete from book where bookId = #{id}")
    public int deleteBook(int id);

    @Insert(" insert into book (bookName,bookSprice,bookAuthor,bookCount) values(#{bookName},#{bookSprice},#{bookAuthor},#{bookCount})")
    public int addBook(Book book);

    @Update("update book set bookName=#{bookName},bookSprice=#{bookSprice},bookAuthor=#{bookAuthor},bookCount=#{bookCount} where bookId=#{bookId}")
    public int updateBook(Book book);


}
