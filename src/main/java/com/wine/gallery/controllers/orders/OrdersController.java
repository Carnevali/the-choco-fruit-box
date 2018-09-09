package com.wine.gallery.controllers.orders;

import com.wine.gallery.models.orders.Orders;
import com.wine.gallery.services.interfaces.customers.CustomersService;
import com.wine.gallery.services.interfaces.orders.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@RestController
@RequestMapping("/api/orders")
@Transactional
public class OrdersController {
    public static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    OrdersService ordersService;

    @Autowired
    CustomersService customersService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createOrderWithoutSubscription(@RequestBody Orders orders, UriComponentsBuilder ucBuilder) {
        logger.info("Buying random chocolates (Single order) : {}", orders);

        customersService.update(orders.getCustomers());
        ordersService.save(orders);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/orders/{id}").buildAndExpand(orders.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}