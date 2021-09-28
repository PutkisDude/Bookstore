package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository catRepository;
	
	@GetMapping("/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", catRepository.findAll());
		return "categorylist";
	}
	
	@GetMapping("/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@GetMapping("/editcategory/{id}")
	public String editCategory(@PathVariable("id") Long catId, Model model) {
		model.addAttribute("category", catRepository.findById(catId).get());
		return "renamecat";
	}
	
	@PostMapping("/savecat")
	public String saveCategory(Category category) {
		catRepository.save(category);
		return "redirect:categorylist";
	}
}
