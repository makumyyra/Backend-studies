package s24.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import s24.bookstore.model.Book;
import s24.bookstore.model.BookRepository;
import s24.bookstore.model.CategoryRepository;
import s24.bookstore.model.AppUserRepository;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository cRepository;

	@Autowired
	private AppUserRepository AppUserRepository;

	@GetMapping("/index")
	public String indexPage(Model model) {
		model.addAttribute("books", repository.findAll());
		return "index";
	}

	@GetMapping("/booklist")
	public String booklistPage(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addbook")
	public String addbookPage(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", cRepository.findAll());
		return "addBook";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/savebook")
	public String savebook(Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", cRepository.findAll());
		return "editBook";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		System.out.println("delete book " + id);
		repository.deleteById(id);
		return "redirect:/booklist";
	}

}
