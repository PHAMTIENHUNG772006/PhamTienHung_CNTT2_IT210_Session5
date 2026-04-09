package com.re.session5.bai5.service;

import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderService {

    public double calculateTotal(double price, int quantity) {
        double subTotal = price * quantity;
        double vat = subTotal * 0.1;
        return subTotal + vat;
    }
}
