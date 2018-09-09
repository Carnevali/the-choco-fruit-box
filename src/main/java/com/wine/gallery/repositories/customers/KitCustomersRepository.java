package com.wine.gallery.repositories.customers;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.customers.KitCustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Repository
public interface KitCustomersRepository extends JpaRepository<KitCustomers, Long> {
    KitCustomers findByCustomers(Customers customers);
}