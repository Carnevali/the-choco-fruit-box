package com.wine.gallery.repositories.chocolates;

import com.sun.org.apache.xpath.internal.operations.String;
import com.wine.gallery.models.chocolates.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Repository
public interface FruitsRepository extends JpaRepository<Fruits, Long> {
    Fruits findByDescription(String description);
}