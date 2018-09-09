package com.wine.gallery.repositories.subscriptions;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.subscriptions.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Long> {
    Subscriptions findByCustomers(Customers customers);
}