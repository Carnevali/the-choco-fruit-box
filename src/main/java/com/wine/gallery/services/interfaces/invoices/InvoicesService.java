package com.wine.gallery.services.interfaces.invoices;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.invoices.Invoices;
import com.wine.gallery.models.orders.Orders;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

public interface InvoicesService {
    Invoices findById(Long id);
    List<Invoices> findByCustomers(Customers customers);
    Invoices save(Invoices invoices);
    Invoices update(Invoices invoices);
    List<Orders>  generateInvoices();
    void closeOrders(List<Orders> ordersList);
}