package cn.qqa.service;

import cn.qqa.dao.BooksMapper;
import cn.qqa.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    //service层调用dao层：组合dao
    @Autowired
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    public Integer addBook(Books books) {
        return booksMapper.addBook(books);
    }

    public Integer deleteBookById(Integer id) {
        return booksMapper.deleteBookById(id);
    }

    public Integer updateBook(Books books) {
        System.out.println("update"+books);
        return booksMapper.updateBook(books);
    }

    public Books queryBookById(Integer id) {
        return booksMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return booksMapper.queryAllBook();
    }

    public List<Books> queryBookByName(String bookName) {
        return booksMapper.queryBookByName(bookName);
    }

}
