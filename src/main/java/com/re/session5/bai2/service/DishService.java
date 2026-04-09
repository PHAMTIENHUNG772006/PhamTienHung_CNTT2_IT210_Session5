package com.re.session5.bai2.service;

import com.re.session5.bai2.model.Dish;
import com.re.session5.bai2.repository.DishRepoditory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dishServiceBai2")
public class DishService {

    @Autowired
    private DishRepoditory dishRepoditory;

    public List<Dish> getDishes() {
        return dishRepoditory.getDishes();
    }

}
