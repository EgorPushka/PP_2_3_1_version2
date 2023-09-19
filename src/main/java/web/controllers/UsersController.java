package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.services.UserServices;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

	private final UserServices userServices;

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

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }


}