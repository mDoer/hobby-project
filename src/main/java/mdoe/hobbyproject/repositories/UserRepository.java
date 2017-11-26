package mdoe.hobbyproject.repositories;

import mdoe.hobbyproject.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
