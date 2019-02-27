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
	private PublisherRepository publisherRepository;

	@Autowired
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {

		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {

		Author eric = new Author("Eric", "Evans");
		Publisher harperCollins = new Publisher("Harper Collins", "NY");
		Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
		eric.getBooks()
			.add(ddd);
		ddd.getAuthors()
		   .add(eric);

		publisherRepository.save(harperCollins);
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Publisher workx = new Publisher("Worx", "CF");
		Book noEJB = new Book("J2EE Development without EJB", "2345", workx);
		rod.getBooks()
		   .add(noEJB);
		noEJB.getAuthors()
			 .add(rod);

		publisherRepository.save(workx);
		authorRepository.save(rod);
		bookRepository.save(noEJB);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

		initData();
	}
}
