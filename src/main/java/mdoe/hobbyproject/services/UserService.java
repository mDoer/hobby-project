package mdoe.hobbyproject.services;

import mdoe.hobbyproject.domain.User;

public interface UserService extends CRUDService<User> {
    User findByUsername(String username);
}
