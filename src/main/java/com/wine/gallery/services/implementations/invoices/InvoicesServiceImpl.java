package com.wine.gallery.services.implementations.invoices;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.invoices.Invoices;
import com.wine.gallery.models.orders.Orders;
import com.wine.gallery.repositories.invoices.InvoicesRepository;
import com.wine.gallery.services.interfaces.invoices.InvoicesService;
import com.wine.gallery.services.interfaces.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Service("invoicesService")
@Transactional
public class InvoicesServiceImpl implements InvoicesService {

    @Autowired
    private InvoicesRepository invoicesRepository;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private InvoicesService invoicesService;

    public Invoices findById(Long id) {
        return invoicesRepository.findById(id).orElse(null);
    }

    public List<Invoices> findByCustomers(Customers customers) {
        return invoicesRepository.findByCustomers(customers);
    }

    public Invoices save(Invoices invoices) {
        return invoicesRepository.save(invoices);
    }

    public Invoices update(Invoices invoices){
        return save(invoices);
    }

    public List<Orders> generateInvoices() {
        List<Orders> ordersList = ordersService.findOrdersToGenerateInvoices();

        ordersList.forEach(order -> {
            if (!order.getClosed()) {
                Invoices invoices = new Invoices(order.generateClosingDateByCustomer(), order.getTotal(), "STRIPE_KEY", order);
                invoicesService.save(invoices);
            }
        });

        return ordersList;
    }

    public void closeOrders(List<Orders> ordersList) {
        ordersList.forEach(order -> {
            order.closeOrder();
            ordersService.update(order);
        });
    }
}
