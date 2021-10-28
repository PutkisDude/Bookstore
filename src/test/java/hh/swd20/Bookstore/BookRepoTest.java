package hh.swd20.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepoTest {

	
	@Autowired
	private BookRepository bookrepo;
	
	@Test
	public void bookRepoIsNotEmpty() {
		List<Book> books = (List<Book>) bookrepo.findAll();
		assertThat(books).isNotEmpty();
	}
	
	@Test
    public void createNewBook() {
		Book book = new Book("test", "tester", "", 2021, 19.99, null);
		bookrepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		assertThat(bookrepo.findById((long) 1)).isNotEmpty();
		bookrepo.deleteById((long) 1);
		assertThat(bookrepo.findById((long) 1)).isEmpty();
	}

	
}
