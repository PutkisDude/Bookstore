package hh.swd20.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(CategoryRepository catRepository, BookRepository bookRepository, UserRepository userRepository) {
		return (args) -> {
			
			
			Category fantasy = new Category("Fantasy");
			Category selfhelp = new Category("Self-help");
			Category biography = new Category("Biography");
			
			catRepository.save(fantasy);
			catRepository.save(selfhelp);
			catRepository.save(biography);
			
			
			log.info("Fetch all the categories");
			for(Category category : catRepository.findAll()) {
				log.info(category.toString());
			}
			
			
			Book hobbit = new Book("The Hobbit", "J.R.R Tolkien", "", 1937, 29.99, fantasy);
			Book happiness = new Book("The Art of Happiness", "Dalai Lama XIV, Howard C. Butler", "", 1998, 39.99, selfhelp);
			Book lemmy = new Book("Lemmy White Line Fever", "Janis Garza, Lemmy Kilmister", "", 2003, 15.95, biography);
			
			bookRepository.save(hobbit);
			bookRepository.save(happiness);
			bookRepository.save(lemmy);

			log.info("Fetch all the books");
			for(Book books : bookRepository.findAll()) {
				log.info(books.toString());
			}
			
			User user1 = new User("user", "$2a$10$OH1Qx4VKIl0vqNERI9VhtO4H6B2UZ/yVGYuSIyduJFiLvsFb8mcOG", "user@ubookstore.hh", "USER");
			User user2 = new User("admin", "$2a$10$mNrlUyl.atQTB/3yXbGB0.2Fh53.I6SMnBf47LeNf6to4nHQESsV6", "admin@bookstore.hh", "ADMIN");			
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}
