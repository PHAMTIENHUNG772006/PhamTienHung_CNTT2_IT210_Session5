package com.re.session5.bai2.controller;

import com.re.session5.bai2.model.Dish;
import com.re.session5.bai2.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Controller("dishControllerBai2")
@RequestMapping({"/","/dish"})
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/bai2/dish")
    public String showDish(Model model){

        List<Dish> dishes = dishService.getDishes();

        model.addAttribute("dishes", dishes);
        return "dish-list";
    }
}