package mdoe.hobbyproject.repositories;

import mdoe.hobbyproject.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
