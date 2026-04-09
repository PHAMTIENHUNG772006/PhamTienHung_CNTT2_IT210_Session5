package com.re.session5.bai5.controller;

import com.re.session5.bai3.model.Dish;
import com.re.session5.bai5.service.DishService;
import com.re.session5.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("dishDetailControllerBai5")
@RequestMapping("/bai5")
public class DishDetailController {

    @Autowired
    private DishService dishService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/detail/{id}")
    public String showOrderDetail(@PathVariable("id") int id, Model model) {
        Dish dish = dishService.findById(id);

        if (dish == null) {
            throw new RuntimeException("Món ăn không tồn tại trong thực đơn!");
        }


        double totalPrice = orderService.calculateTotal(dish.getPrice(), 1);

        model.addAttribute("dish", dish);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("vat", "10%");

        return "order-detail";
    }
}