package mdoe.hobbyproject.bootstrap;

import mdoe.hobbyproject.domain.Role;
import mdoe.hobbyproject.domain.User;
import mdoe.hobbyproject.repositories.ProductRepository;
import mdoe.hobbyproject.services.RoleService;
import mdoe.hobbyproject.services.UserService;
import mdoe.hobbyproject.services.security.EncryptionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private UserService userService;
    private RoleService roleService;
    private EncryptionService encryptionService;

    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadUsers();
        loadRoles();
        assignUsersToUserRole();
        assignUsersToAdminRole();
    }

    private void loadProducts() {

    }

    private void loadUsers() {
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        user1.setEncryptedPassword(encryptionService.encryptString(user1.getPassword()));
        user1.setFirstName("simple");
        user1.setLastName("user");
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        user2.setFirstName("super");
        user2.setLastName("admin");
        userService.saveOrUpdate(user2);

    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        log.info("Saved role" + role.getRole());
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        log.info("Saved role" + adminRole.getRole());
    }

    private void assignUsersToUserRole() {

        User user1 = userService.getById(1);
        user1.addRole(roleService.getById(1));
        userService.saveOrUpdate(user1);
    }

    private void assignUsersToAdminRole() {



    }
}


