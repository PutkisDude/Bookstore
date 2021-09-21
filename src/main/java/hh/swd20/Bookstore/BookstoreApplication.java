package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book hobbit = new Book("The Hobbit", "J.R.R Tolkien", "", 1937, 29.99);
			Book happiness = new Book("The Art of Happiness", "Dalai Lama XIV, Howard C. Butler", "", 1998, 39.99);
			Book lemmy = new Book("Lemmy White Line Fever", "Janis Garza, Lemmy Kilmister", "", 2003, 15.95);
			
			repository.save(hobbit);
			repository.save(happiness);
			repository.save(lemmy);

		};
	}
}
