package birla.prasoon.spring5webapp.repositories;

import birla.prasoon.spring5webapp.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
