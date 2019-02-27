package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorController {

	private final String AUTHORS = "authors";
	private final AuthorRepository authorRepository;

	@Autowired
	public AuthorController(AuthorRepository authorRepository) {

		this.authorRepository = authorRepository;
	}

	/**
	 * associate the term books with a view called books
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/" + AUTHORS)
	public String getAuthors(Model model) {

		model.addAttribute(AUTHORS, authorRepository.findAll());

		return AUTHORS;
	}

}
