package com.wine.gallery.services.implementations.subscriptions;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.subscriptions.Subscriptions;
import com.wine.gallery.repositories.subscriptions.SubscriptionsRepository;
import com.wine.gallery.services.interfaces.subscriptions.SubscriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Service("subscriptionsService")
@Transactional
public class SubscriptionsServiceImpl implements SubscriptionsService {

    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    public Subscriptions findById(Long id) {
        return subscriptionsRepository.findById(id).orElse(null);
    }

    public Subscriptions save(Subscriptions subscriptions) {
        return subscriptionsRepository.save(subscriptions);
    }

    public Subscriptions update(Subscriptions subscriptions){
        return save(subscriptions);
    }

    public void generateSubscriptionsByCustomer(Customers customers) {
        Subscriptions subscriptions = new Subscriptions("New subscriptions", customers.getType(), "STRIP_KEY", customers);
        subscriptionsRepository.save(subscriptions);
    }
}
