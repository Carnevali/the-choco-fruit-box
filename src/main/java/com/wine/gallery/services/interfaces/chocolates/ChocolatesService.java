package com.wine.gallery.services.interfaces.chocolates;

import com.wine.gallery.models.chocolates.Chocolates;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

public interface ChocolatesService {
    Chocolates findById(Long id);
    Chocolates findByDescription(String description);
    Chocolates save(Chocolates chocolates);
    Chocolates update(Chocolates chocolates);
}