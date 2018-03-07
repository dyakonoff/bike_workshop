package com.dyakonoff.workshop.web.order;

import com.dyakonoff.workshop.entity.OrderStatus;
import com.dyakonoff.workshop.service.OrderService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.dyakonoff.workshop.entity.Order;

import javax.inject.Inject;

public class OrderEdit extends AbstractEditor<Order> {
    @Inject
    private OrderService orderService;

    @Override
    protected void initNewItem(Order item) {
//        super.initNewItem(item);
        item.setStatus(OrderStatus.NEW);
    }

    @Override
    protected boolean preCommit() {
        Order order = getItem();
        order.setAmount((orderService.calculateAmount(order)));
        return super.preCommit();
    }
}