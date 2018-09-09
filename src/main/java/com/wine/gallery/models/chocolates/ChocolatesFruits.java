package com.wine.gallery.models.chocolates;

import com.wine.gallery.models.foreignkeys.ChocolatesFruitsPK;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by felipecarnevalli on 9/9/18.
 */
@Entity
@Table(name = "chocolates_fruits")
@IdClass(ChocolatesFruitsPK.class)
public class ChocolatesFruits implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "chocolates_id", referencedColumnName = "id")
    private Chocolates chocolates;

    @Id
    @ManyToOne
    @JoinColumn(name = "fruits_id", referencedColumnName = "id")
    private Fruits fruits;

    public ChocolatesFruits() {

    }

    public ChocolatesFruits(Chocolates chocolates, Fruits fruits) {
        super();

        this.chocolates = chocolates;
        this.fruits = fruits;
    }

    public Chocolates getChocolates() {
        return chocolates;
    }

    public Fruits getFruits() {
        return fruits;
    }
}