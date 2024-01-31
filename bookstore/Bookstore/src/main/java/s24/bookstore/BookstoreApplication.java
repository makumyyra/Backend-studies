package s24.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s24.bookstore.model.Book;
import s24.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			System.out.println("save a couple of books");
			repository.save(new Book("Mercury", "John Johnson", 1992, "123456", 20.5 ));
			repository.save(new Book("Falling", "Mary Johnson", 2010, "789012", 30.5 ));
			repository.save(new Book("Venus", "Dick Johnson", 2022, "000010", 10.0 ));
			repository.save(new Book("Mars", "Bettie Johnson", 2005, "100000", 18.8 ));
			
			
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}

		};
	}

}
