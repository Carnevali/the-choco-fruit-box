package com.wine.gallery.repositories.orders;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByCustomers(Customers customers);
    List<Orders> findByClosingDate(Date closingDate);
}