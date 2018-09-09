package com.wine.gallery.services.implementations.customers;

import com.wine.gallery.models.customers.KitCustomers;
import com.wine.gallery.repositories.customers.KitCustomersRepository;
import com.wine.gallery.services.interfaces.customers.KitCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Service("kitCustomersService")
@Transactional
public class KitCustomersServiceImpl implements KitCustomersService {

    @Autowired
    private KitCustomersRepository kitCustomersRepository;

    public KitCustomers findById(Long id) {
        return kitCustomersRepository.findById(id).orElse(null);
    }

    public KitCustomers save(KitCustomers kitCustomers) {
        return kitCustomersRepository.save(kitCustomers);
    }

    public KitCustomers update(KitCustomers kitCustomers){
        return save(kitCustomers);
    }
}
