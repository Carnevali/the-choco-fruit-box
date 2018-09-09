package com.wine.gallery.services.interfaces.subscriptions;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.subscriptions.Subscriptions;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

public interface SubscriptionsService {
    Subscriptions findById(Long id);
    Subscriptions save(Subscriptions subscriptions);
    Subscriptions update(Subscriptions subscriptions);
    void generateSubscriptionsByCustomer(Customers customers);
}