package com.wine.gallery.services.interfaces.customers;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.customers.Recommendations;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

public interface RecommendationsService {
    Recommendations findById(Long id);
    Recommendations save(Recommendations recommendations);
    Recommendations update(Recommendations recommendations);
    List<Recommendations> findByCustomers(Customers customers);
}