package com.wine.gallery.models.chocolates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wine.gallery.enums.chocolates.ChocolatesType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Entity
@Table(name="chocolates")
@JsonIgnoreProperties( ignoreUnknown = true )
public class Chocolates implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="description", nullable=false)
    private String description;

    @Column(name="date_created", nullable=false)
    private Date dateCreated;

    @Column(name="type", nullable=false)
    @Enumerated(EnumType.STRING)
    private ChocolatesType type;

    @OneToMany(mappedBy = "chocolates", fetch = FetchType.EAGER)
    private List<ChocolatesFruits> chocolatesFruits = new ArrayList<>();

    @NotEmpty
    @Column(name="price", nullable=false)
    private Double price = 0.00;

    public Chocolates() {

    }

    public Chocolates(String description, ChocolatesType type, Double price) {
        super();

        this.description = description;
        this.dateCreated = new Date();
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ChocolatesType getType() {
        return type;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public List<ChocolatesFruits> getChocolatesFruits() {
        return chocolatesFruits;
    }

    public Double getPrice() { return price; }

}