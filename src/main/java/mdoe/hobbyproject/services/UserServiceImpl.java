package mdoe.hobbyproject.services;

import mdoe.hobbyproject.domain.User;
import mdoe.hobbyproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

    private UserRepository userRepository;

    @Autowired
    public void setProductRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
