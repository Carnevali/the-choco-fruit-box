package com.wine.gallery.services.implementations.chocolates;

import com.wine.gallery.models.chocolates.Chocolates;
import com.wine.gallery.repositories.chocolates.ChocolatesRepository;
import com.wine.gallery.services.interfaces.chocolates.ChocolatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Service("chocolatesService")
@Transactional
public class ChocolatesServiceImpl implements ChocolatesService {

    @Autowired
    private ChocolatesRepository chocolatesRepository;

    public Chocolates findById(Long id) {
        return chocolatesRepository.findById(id).orElse(null);
    }

    public Chocolates findByDescription(String description) {
        return chocolatesRepository.findByDescription(description);
    }

    public Chocolates save(Chocolates chocolates) {
        return chocolatesRepository.save(chocolates);
    }

    public Chocolates update(Chocolates chocolates){
        return save(chocolates);
    }
}
