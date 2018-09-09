package com.wine.gallery.controllers.customers;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.services.interfaces.customers.CustomersService;
import com.wine.gallery.services.interfaces.subscriptions.SubscriptionsService;
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
@RequestMapping("/api/customers")
@Transactional
public class CustomersController {
    public static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

    @Autowired
    CustomersService customersService;

    @Autowired
    SubscriptionsService subscriptionsService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> signUpSubscriber(@RequestBody Customers customers, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Customer : {}", customers);

        if (customersService.isCustomerExist(customers)) {
            logger.error("Unable to create. This customer already have subscription on the system", customers.getName());
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        subscriptionsService.generateSubscriptionsByCustomer(customers);
        customersService.save(customers);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/customers/{id}").buildAndExpand(customers.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}