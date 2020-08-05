package birla.prasoon.spring5webapp.repositories;

import birla.prasoon.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
