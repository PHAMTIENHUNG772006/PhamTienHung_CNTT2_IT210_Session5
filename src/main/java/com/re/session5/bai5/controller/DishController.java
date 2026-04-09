package com.re.session5.bai5.controller;

import com.re.session5.bai3.model.Dish;
import com.re.session5.bai5.service.DishService;
import com.re.session5.bai5.service.OrderService;
import com.re.session5.bai5.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("dishControllerBai5")
@RequestMapping("/bai5")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/dish")
    public String showDishList(Model model) {
        List<Dish> dishes = dishService.getDishes();
        model.addAttribute("dishes", dishes);
        return "dish-list5";
    }

    @GetMapping("/view/{id}")
    public String showOrderDetail(@PathVariable("id") int id, Model model) {
        Dish dish = dishService.findById(id);

        if (dish == null) {
            throw new BadRequestException("Không tìm thấy món ăn với ID: " + id);
        }

        double totalPrice = orderService.calculateTotal(dish.getPrice(), 1);

        model.addAttribute("dish", dish);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("vat", "10%");

        return "order-detail";
    }
}