package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.web.BookstoreController;
import hh.swd20.Bookstore.web.CategoryController;

@ExtendWith(SpringExtension.class) 
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookstoreController bookStoreController;

	@Autowired
	private CategoryController catController;
	
	@Test
	public void bookStoreContextLoads() {
		assertThat(bookStoreController).isNotNull();
	}
	
	@Test
	public void catContextLoads() {
		assertThat(catController).isNotNull();
	}
	

}
