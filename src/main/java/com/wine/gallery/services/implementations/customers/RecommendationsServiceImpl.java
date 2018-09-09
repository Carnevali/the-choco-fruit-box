package com.wine.gallery.services.implementations.customers;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.customers.Recommendations;
import com.wine.gallery.repositories.customers.RecommendationsRepository;
import com.wine.gallery.services.interfaces.customers.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Service("recommendationsService")
@Transactional
public class RecommendationsServiceImpl implements RecommendationsService {

    @Autowired
    private RecommendationsRepository recommendationsRepository;

    public Recommendations findById(Long id) {
        return recommendationsRepository.findById(id).orElse(null);
    }

    public List<Recommendations> findByCustomers(Customers customers) { return recommendationsRepository.findByCustomers(customers); }

    public Recommendations save(Recommendations recommendations) { return recommendationsRepository.save(recommendations); }

    public Recommendations update(Recommendations recommendations){
        return save(recommendations);
    }
}
