package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.*;
import guru.springframework.spring5webapp.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.*;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	@Autowired
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {

		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	private void initData() {

		System.out.println("called this time!!!");

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
		eric.getBooks()
			.add(ddd);
		ddd.getAuthors()
		   .add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "2345", "Worx");
		rod.getBooks()
		   .add(noEJB);
		noEJB.getAuthors()
			 .add(rod);

		authorRepository.save(rod);
		bookRepository.save(noEJB);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

		initData();
	}
}