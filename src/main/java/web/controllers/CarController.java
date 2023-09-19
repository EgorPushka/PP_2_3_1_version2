package web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.services.CarService;

import java.util.Optional;


@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String printCar(@RequestParam(value = "count", required = false)
                           Optional<Integer> count, Model model) {
        model.addAttribute("cars", carService.indexCarsByCount(count.orElse(0)));
        return "/cars";
    }
}
