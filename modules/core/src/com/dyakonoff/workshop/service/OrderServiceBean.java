package com.dyakonoff.workshop.service;

import com.dyakonoff.workshop.entity.Order;
import com.dyakonoff.workshop.entity.SparePart;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Override
    public BigDecimal calculateAmount(Order order) {
        BigDecimal amount = BigDecimal.ZERO;
        if (order.getHoursSpent() != null) {
            amount = amount.add(new BigDecimal(order.getHoursSpent()))
                    .multiply(order.getMechanic().getHourlyRate());
        }
        if (order.getParts() != null) {
            for (SparePart part : order.getParts()) {
                amount = amount.add(part.getPrice());
            }
        }
        return amount;
    }
}