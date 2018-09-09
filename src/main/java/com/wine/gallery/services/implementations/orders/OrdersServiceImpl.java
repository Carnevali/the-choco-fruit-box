package com.wine.gallery.services.implementations.orders;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.orders.Orders;
import com.wine.gallery.repositories.orders.OrdersRepository;
import com.wine.gallery.services.interfaces.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public Orders findById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public List<Orders> findByCustomers(Customers customers) {
        return ordersRepository.findByCustomers(customers);
    }

    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    public Orders update(Orders orders){
        return save(orders);
    }

    public List<Orders> findOrdersToGenerateInvoices() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, +2);

        return ordersRepository.findByClosingDate(c.getTime());
    }
}
