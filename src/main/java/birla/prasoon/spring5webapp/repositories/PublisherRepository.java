package birla.prasoon.spring5webapp.repositories;

import birla.prasoon.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
