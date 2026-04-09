package com.re.session5.btth.controller;

import com.re.session5.btth.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PromotionController {

    @GetMapping("/promotions")
    public String getPromotions(Model model) {
        List<Dish> promotionDishes = new ArrayList<>();

        promotionDishes.add(new Dish(1, "Phở Bò Đặc Biệt", 60000, 25));
        promotionDishes.add(new Dish(2, "Bún Chả Hà Nội", 50000, 15));
        promotionDishes.add(new Dish(3, "Nem Rán", 30000, 30));

        model.addAttribute("dishes", promotionDishes);
        return "layouts/promotion-list";//123
    }
}