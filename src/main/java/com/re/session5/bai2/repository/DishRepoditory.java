package com.re.session5.bai2.repository;

import com.re.session5.bai2.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("dishRepositoryBai2")
public class DishRepoditory {
    public List<Dish> getDishes() {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(1, "Phở bò", 45000, true));
        dishes.add(new Dish(2, "Bún chả", 40000, false));
        dishes.add(new Dish(3, "Gỏi cuốn", 30000, true));
        dishes.add(new Dish(4, "Bánh mì", 20000, true));
        dishes.add(new Dish(5, "Chè thập cẩm", 25000, false));

        return dishes;
    }
}
