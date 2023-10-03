package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.UserServices;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserServices userServices;

    private static final String REDIRECT_USERS_LIST_PAGE = "redirect:/users";

    @Autowired
    public UsersController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping()
    public String indexUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userServices.indexUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userServices.add(user);
        return REDIRECT_USERS_LIST_PAGE;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.getById(id));
        return "/user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServices.delete(userServices.getById(id));
        return REDIRECT_USERS_LIST_PAGE;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.getById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String editUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        userServices.edit(user);
        return REDIRECT_USERS_LIST_PAGE;
    }

}