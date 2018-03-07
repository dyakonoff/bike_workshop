package com.dyakonoff.workshop.web.order;

import com.dyakonoff.workshop.entity.Order;
import com.dyakonoff.workshop.entity.OrderStatus;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.util.UUID;

public class OrderBrowse extends AbstractLookup {
    @Inject
    private GroupDatasource<Order, UUID> ordersDs;

    public void onNewStatusBtnClick() {
        Order selectedItem = ordersDs.getItem();
        if (selectedItem != null) {
            selectedItem.setStatus(OrderStatus.NEW);
            ordersDs.commit();
        }
    }
}