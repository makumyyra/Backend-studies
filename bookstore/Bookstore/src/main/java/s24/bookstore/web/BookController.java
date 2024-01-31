package s24.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import s24.bookstore.model.BookRepository;


@Controller
public class BookController {
	 
	@Autowired
	private BookRepository repository; 

	@GetMapping("index")
	public String indexPage(Model model) {
		model.addAttribute("books", repository.findAll());
        return "index";
	}

	
	
    // @RequestMapping(value= {"/", "/studentlist"})
    // public String studentList(Model model) {	
    //     model.addAttribute("students", repository.findAll());
    //     return "studentlist";
    // }
	
	



}
