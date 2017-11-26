package mdoe.hobbyproject.services;

import mdoe.hobbyproject.domain.User;

public interface UserService {
    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User product);
}
