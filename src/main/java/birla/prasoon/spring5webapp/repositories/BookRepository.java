package birla.prasoon.spring5webapp.repositories;

import birla.prasoon.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
