package com.re.session5.bai5.service;

import com.re.session5.bai3.model.Dish;
import com.re.session5.bai5.repository.DishRepoditory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dishServiceBai5")
public class DishService {

    @Autowired
    private DishRepoditory dishRepoditory;

    public List<Dish> getDishes() {
        return dishRepoditory.getDishes();
    }

    public Dish findById(int id) {
        List<Dish> dishes = dishRepoditory.getDishes();
        for (Dish dish : dishes) {
            if (dish.getId() == id){
                return dish;
            }
        }

        return null;
    }
}
