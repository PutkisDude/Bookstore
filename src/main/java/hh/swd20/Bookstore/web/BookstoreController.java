package hh.swd20.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookstoreController {

	@GetMapping("")
	public String index(Model model) {
		return "index";
	}
}
