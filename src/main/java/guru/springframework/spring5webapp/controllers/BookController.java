package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

	private final String BOOKS = "books";
	private final BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {

		this.bookRepository = bookRepository;
	}

	/**
	 * associate the term books with a view called books
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/books")
	public String getBooks(Model model) {

		model.addAttribute(BOOKS, bookRepository.findAll());

		return BOOKS;
	}

}
