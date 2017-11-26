package mdoe.hobbyproject.bootstrap;

import mdoe.hobbyproject.domain.User;
import mdoe.hobbyproject.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    private Logger log = Logger.getLogger(UserLoader.class);

    @Autowired
    public void setProductRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User admin = new User();
        admin.setFirstName("super");
        admin.setLastName("admin");
        admin.setCreationDate(new Date());
        userRepository.save(admin);
    }
}