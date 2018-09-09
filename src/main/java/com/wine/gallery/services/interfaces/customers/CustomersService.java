package com.wine.gallery.services.interfaces.customers;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.customers.Recommendations;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

public interface CustomersService {
    Customers findById(Long id);
    Customers findByName(String name);
    Customers save(Customers customers);
    Customers update(Customers customers);
    List<Recommendations> generateRecommendations();
    void sendEmail(List<Recommendations> recommendationsList);
    Boolean isCustomerExist(Customers customers);
}