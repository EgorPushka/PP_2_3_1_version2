package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

	@GetMapping(value = "/")
	public String indexUsers(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC / Hibernate App");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "users";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit");
		return modelAndView;
	}


	
}