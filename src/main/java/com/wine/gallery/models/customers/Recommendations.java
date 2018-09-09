package com.wine.gallery.models.customers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wine.gallery.models.chocolates.Chocolates;
import javax.persistence.*;
import javax.validation.ValidationException;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Entity
@Table(name="recommendations")
@JsonIgnoreProperties( ignoreUnknown = true )
public class Recommendations implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_created", nullable=false)
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="customers_id")
    private Customers customers;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="chocolates_id")
    private Chocolates chocolates;

    public Recommendations() {

    }

    public Recommendations(Customers customers, Chocolates chocolates) throws ValidationException {
        super();

        this.customers = customers;
        this.dateCreated = new Date();
        this.chocolates = chocolates;
    }

    public Long getId() {
        return id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public Chocolates getChocolates() {
        return chocolates;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

}