package com.wine.gallery.repositories.chocolates;

import com.wine.gallery.models.chocolates.Chocolates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Repository
public interface ChocolatesRepository extends JpaRepository<Chocolates, Long> {
    Chocolates findByDescription(String description);
}