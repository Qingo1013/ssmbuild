package cn.qqa.dao;

import cn.qqa.pojo.Books;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;


public class BookMapperImpl extends SqlSessionDaoSupport implements BooksMapper {
    public Integer addBook(Books books) {

        return getSqlSession().getMapper(BooksMapper.class).addBook(books);
    }

    public Integer deleteBookById(Integer id) {
        return getSqlSession().getMapper(BooksMapper.class).deleteBookById(id);
    }

    public Integer updateBook(Books books) {
        return getSqlSession().getMapper(BooksMapper.class).updateBook(books);
    }

    public Books queryBookById(Integer id) {
        return getSqlSession().getMapper(BooksMapper.class).queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return getSqlSession().getMapper(BooksMapper.class).queryAllBook();
    }

    public List<Books> queryBookByName(String bookName) {
        return getSqlSession().getMapper(BooksMapper.class).queryBookByName(bookName);
    }
}
