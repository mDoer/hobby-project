package mdoe.hobbyproject.controllers;


import mdoe.hobbyproject.domain.Role;
import mdoe.hobbyproject.domain.User;
import mdoe.hobbyproject.services.RoleService;
import mdoe.hobbyproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.listAll());
        return "users";
    }

    @RequestMapping("user/edit/{id}")
    public String edit( @PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles", roleService.listAll());
        return "userform";
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "userdetail";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam(value = "selectedRoles", required = false) int[] selectedRoles,
                           BindingResult bindingResult, Model model) {

        System.out.println(user +"userRoles" +user.getRoles());


        for (int selectedRoleID : selectedRoles) {
            Role selectedRole = roleService.getById(selectedRoleID);
            user.addRole(selectedRole);
            roleService.saveOrUpdate(selectedRole);
        }
        userService.saveOrUpdate(user);

        return "redirect:/user/" + user.getId();
    }


}


