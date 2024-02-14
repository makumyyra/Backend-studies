package s24.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import s24.bookstore.model.Book;
import s24.bookstore.model.BookRepository;
import s24.bookstore.model.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RESTBookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository catRepository;

    @GetMapping("/books")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/books{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {

        return bookRepository.findById(bookId);
    }

}
