package com.wine.gallery.services.interfaces.customers;

import com.wine.gallery.models.customers.KitCustomers;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

public interface KitCustomersService {
    KitCustomers findById(Long id);
    KitCustomers save(KitCustomers kitCustomers);
    KitCustomers update(KitCustomers kitCustomers);
}