package s24.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s24.bookstore.model.Book;
import s24.bookstore.model.BookRepository;
import s24.bookstore.model.Category;
import s24.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bRepository, CategoryRepository cRepository) {
		return (args) -> {
			System.out.println("save a couple of books");

			cRepository.save(new Category("Fiction"));
			cRepository.save(new Category("Romance"));
			cRepository.save(new Category("Crime"));

			bRepository.save(new Book("Mercury",
					"John Johnson",
					1992,
					"123456",
					20.5,
					cRepository.findByName("Fiction").get(0)));

			bRepository.save(new Book("Falling",
					"Mary Johnson",
					2010,
					"789012",
					30.5,
					cRepository.findByName("Romance").get(0)));

			bRepository.save(new Book("Venus",
					"Dick Johnson",
					2022,
					"000010",
					10.0,
					cRepository.findByName("Fiction").get(0)));

			bRepository.save(new Book("Mars",
					"Bettie Johnson",
					2005,
					"100000",
					18.8,
					cRepository.findByName("Crime").get(0)));

			for (Book book : bRepository.findAll()) {
				System.out.println(book.toString());
			}

		};
	}

}
