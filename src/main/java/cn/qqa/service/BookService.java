package cn.qqa.service;

import cn.qqa.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //增加一本书
    public Integer addBook(Books books);
    //删除一本书
    public Integer deleteBookById(Integer id);
    //查询一本书
    public Integer updateBook(Books books);
    //修稿一本书
    public Books queryBookById(Integer id);
    //查询全部的书
    public List<Books> queryAllBook();

    //根据书名查询
    List<Books> queryBookByName(String bookName);

}
