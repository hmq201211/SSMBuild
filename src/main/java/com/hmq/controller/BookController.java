package com.hmq.controller;

import com.hmq.pojo.Books;
import com.hmq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    @Qualifier("bookServiceImpl")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/getAllBooks")
    public String getAllBooks(Model model) {
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list", books);
        return "list";
    }
    @RequestMapping("/getLikeBooks")
    public String getLikeBooks(String keywords, Model model) {
        List<Books> books = bookService.queryLikeBooks(keywords);
        model.addAttribute("list", books);
        return "list";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books) {
        int result = bookService.addBook(books);
        if (result > 0)
            return "redirect:/book/getAllBooks";
        else
            return "forward:index.jsp";
    }
    @RequestMapping("/update")
    public String update(Books books) {
        System.out.println(books);
        int result = bookService.updateBook(books);
        if (result > 0)
            return "redirect:/book/getAllBooks";
        else
            return "forward:index.jsp";
    }
    @RequestMapping("/delete")
    public String deleteBook(int id) {
        int result = bookService.deleteBookById(id);
        if (result > 0)
            return "redirect:/book/getAllBooks";
        else
            return "forward:index.jsp";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "add";
    }

    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("book", books);
        return "update";
    }
}
