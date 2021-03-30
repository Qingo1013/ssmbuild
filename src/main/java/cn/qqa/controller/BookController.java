package cn.qqa.controller;

import cn.qqa.pojo.Books;
import cn.qqa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller层调用service层

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    //增加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books ){
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向到@RequestMapping("/allBook")
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Integer id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("-----------------------"+books);
        Integer integer = bookService.updateBook(books);
        if(integer>0){
            System.out.println("=======================修改成功");
        }else{
            System.out.println("失败");
        }
        System.out.println();
        return "redirect:/book/allBook";
    }


    //删除书籍
    @RequestMapping("/deleteBook/{id}")
    public String updateBook(@PathVariable("id") Integer id){
        Integer integer = bookService.deleteBookById(id);
        if(integer>0){
            System.out.println("=======================删除成功");
        }else{
            System.out.println("失败");
        }
        System.out.println();
        return "redirect:/book/allBook.action";
    }


    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){

        List<Books> books = bookService.queryBookByName(queryBookName);
       if(books.isEmpty()){
           books = bookService.queryAllBook();
           model.addAttribute("error","未查到");
       }
        model.addAttribute("list",books);
        return "allBook";
    }


}
