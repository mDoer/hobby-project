package mdoe.hobbyproject.controllers;


import mdoe.hobbyproject.domain.Product;
import mdoe.hobbyproject.domain.User;
import mdoe.hobbyproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class UserController {

    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", userService.listAll());
        return "users";
    }

    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "userform";
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "userdetail";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user){
       /* user.setModifiedData(new Date());*/
        userService.saveOrUpdate(user);

        return "redirect:/user/" + user.getId();
    }


}
