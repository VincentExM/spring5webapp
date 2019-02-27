package guru.springframework.spring5webapp.model;

import java.util.*;

import javax.persistence.*;

import lombok.*;

/**
 * testing shit
 * now testing with sourcetree
 * another test
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String title;
	private String isbn;
	private String publisher;

	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();

	public Book(String title, String isbn, String publisher) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return Objects.equals(id, book.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
