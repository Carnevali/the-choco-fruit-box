package com.wine.gallery.repositories.customers;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.customers.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Repository
public interface RecommendationsRepository extends JpaRepository<Recommendations, Long> {
    List<Recommendations> findByCustomers(Customers customers);
}