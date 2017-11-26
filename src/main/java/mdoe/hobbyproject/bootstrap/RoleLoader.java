package mdoe.hobbyproject.bootstrap;

import mdoe.hobbyproject.domain.Role;
import mdoe.hobbyproject.domain.User;
import mdoe.hobbyproject.repositories.RoleRepository;
import mdoe.hobbyproject.repositories.UserRepository;
import mdoe.hobbyproject.services.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RoleLoader implements ApplicationListener<ContextRefreshedEvent> {

    private RoleRepository roleRepository;

    private RoleService roleService;

    private Logger log = Logger.getLogger(UserLoader.class);

    @Autowired
    public void setProductRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Role admin = new Role();
    admin.setRole("admin");
        roleRepository.save(admin);
    }
}