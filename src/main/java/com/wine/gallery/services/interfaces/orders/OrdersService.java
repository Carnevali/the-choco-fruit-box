package com.wine.gallery.services.interfaces.orders;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.orders.Orders;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

public interface OrdersService {
    Orders findById(Long id);
    List<Orders> findByCustomers(Customers customers);
    Orders save(Orders orders);
    Orders update(Orders orders);
    List<Orders> findOrdersToGenerateInvoices();
}