package hh.swd20.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepoTest {

	@Autowired
	CategoryRepository catRepo;
	
	@Test
	public void createCatTest() {
		Category cat = new Category("test");
		catRepo.save(cat);
		assertThat(cat.getId()).isNotNull();
	}
	
	@Test
	public void changeCatNameTest() {
		Category catName = new Category("Art");
		catRepo.save(catName);
		long catId = catName.getId();
		
		catName.setName("Modern Art");
		catRepo.save(catName);
		
		String nameFromId = catRepo.findById(catId).get().getName();
		
		assertThat(nameFromId != "Art" && nameFromId == "Modern Art");
		
	}
}
