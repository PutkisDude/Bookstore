package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.Bookstore.domain.BookRepository;


@Controller
public class BookstoreController {

	@Autowired
	private BookRepository repository;
	
	@GetMapping("")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
}
