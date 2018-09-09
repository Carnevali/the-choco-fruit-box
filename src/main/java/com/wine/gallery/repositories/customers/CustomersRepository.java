package com.wine.gallery.repositories.customers;

import com.wine.gallery.enums.subscriptions.SubscriptionsType;
import com.wine.gallery.models.customers.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
    Customers findByName(String name);
    Customers findByEmail(String email);
    List<Customers> findByType(SubscriptionsType type);
}