package com.wine.gallery.models.customers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wine.gallery.enums.subscriptions.SubscriptionsType;
import com.wine.gallery.models.chocolates.Chocolates;
import com.wine.gallery.services.interfaces.customers.KitCustomersService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Entity
@Table(name="customers")
@JsonIgnoreProperties( ignoreUnknown = true )
public class Customers implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="name", nullable=false)
    private String name;

    @NotEmpty
    @Column(name="email", nullable=false)
    private String email;

    @Column(name="date_created", nullable=false)
    private Date dateCreated;

    @Column(name="closing_day", nullable=false)
    private Integer closingDay;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="kit_customers_id")
    private KitCustomers kitCustomers;

    @Column(name="type", nullable=false)
    @Enumerated(EnumType.STRING)
    private SubscriptionsType type;

    @Autowired
    @Transient
    private KitCustomersService kitCustomersService;

    public Customers() {

    }

    public Customers(String name, Integer closingDay, String email, SubscriptionsType type) throws ValidationException {
        super();

        this.name = name;
        this.dateCreated = new Date();
        this.email = email;
        this.type = type;

        if (closingDay < 1 && closingDay > 28) {
            throw new ValidationException("Invalid closing day.");
        } else {
            this.closingDay = closingDay;
        }
    }

    public void updateKitCustomer(Chocolates chocolates) {
        KitCustomers kit = new KitCustomers(this, chocolates);
        kitCustomersService.save(kit);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getClosingDay() {
        return closingDay;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public KitCustomers getKitCustomers() { return kitCustomers; }

    public SubscriptionsType getType() { return type; }
}