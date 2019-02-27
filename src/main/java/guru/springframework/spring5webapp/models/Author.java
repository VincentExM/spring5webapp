package guru.springframework.spring5webapp.models;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Author author = (Author) o;
		return Objects.equals(id, author.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
