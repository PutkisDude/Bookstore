package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;


@Controller
public class BookstoreController {

	@Autowired
	private BookRepository repository;
	
	@GetMapping("")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId).get());
		return "editbook";
	}
	
	@PostMapping("/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
}
