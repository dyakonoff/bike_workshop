package com.dyakonoff.workshop.service;


import com.dyakonoff.workshop.entity.Order;

import java.math.BigDecimal;

public interface OrderService {
    String NAME = "workshop_OrderService";

    BigDecimal calculateAmount(Order order);
}