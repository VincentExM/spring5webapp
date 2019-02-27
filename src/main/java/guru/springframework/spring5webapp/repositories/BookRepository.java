package guru.springframework.spring5webapp.repositories;

import java.util.*;

import guru.springframework.spring5webapp.models.*;
import org.springframework.data.repository.*;

public interface BookRepository extends CrudRepository<Book, UUID> {

}
