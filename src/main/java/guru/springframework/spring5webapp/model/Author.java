package guru.springframework.spring5webapp.model;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();



}
