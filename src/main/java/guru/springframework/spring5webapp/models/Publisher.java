package guru.springframework.spring5webapp.models;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String name;
	private String address;

	public Publisher(String name, String address) {

		this.name = name;
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Publisher publisher = (Publisher) o;
		return Objects.equals(id, publisher.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
