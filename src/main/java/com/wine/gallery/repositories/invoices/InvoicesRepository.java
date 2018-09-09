package com.wine.gallery.repositories.invoices;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.invoices.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Long> {
    List<Invoices> findByCustomers(Customers customers);
}