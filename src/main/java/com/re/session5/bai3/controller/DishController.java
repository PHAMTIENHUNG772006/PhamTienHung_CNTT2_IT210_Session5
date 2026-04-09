package com.re.session5.bai3.controller;

import com.re.session5.bai3.model.Dish;
import com.re.session5.bai3.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller("dishControllerBai3")
@RequestMapping({"/","/dish"})
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/bai3/dish")
    public String showDish(Model model){

        List<Dish> dishes = dishService.getDishes();

        model.addAttribute("dishes", dishes);
        return "dish-list";
    }

    @GetMapping("bai3/edit/{id}")
    public String showEditForm(@PathVariable("id") int id,Model model, RedirectAttributes ra) {
        Dish dish = dishService.findById(id);

        if (dish == null) {
            ra.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai3/dish";
        }

        System.out.println("Món ăn đang sửa: " + dish.getId());

        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}