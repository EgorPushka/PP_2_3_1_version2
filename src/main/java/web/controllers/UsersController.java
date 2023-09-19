package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.models.User;
import web.services.UserServices;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

	private final UserServices userServices;

    private static final String REDIRECT_USERS_LIST_PAGE = "redirect:/users";

    @Autowired
    public UsersController(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloPage() {
        return "index";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView indexUsers() {
        ModelAndView view = new ModelAndView();
        view.setViewName("users");
        view.addObject("users", userServices.indexUsers());
        return view;
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }
    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userServices.add(user);
        return REDIRECT_USERS_LIST_PAGE;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }


    @DeleteMapping("/users/{id}")
    public String deleteUser(@ModelAttribute("user") User user,
                             @PathVariable("id") int id) {
        userServices.delete(user);
        return REDIRECT_USERS_LIST_PAGE;
    }

}