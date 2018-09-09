package com.wine.gallery.models.subscriptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wine.gallery.enums.subscriptions.SubscriptionsType;
import com.wine.gallery.models.customers.Customers;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Entity
@Table(name="subscriptions")
@JsonIgnoreProperties( ignoreUnknown = true )
public class Subscriptions implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="description", nullable=false)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="customers_id")
    private Customers customers;

    @NotEmpty
    @Column(name="stripe_subscription_key", nullable=false)
    private String stripeSubscriptionKey;

    @Column(name="date_created", nullable=false)
    private Date dateCreated;

    @Column(name="type", nullable=false)
    @Enumerated(EnumType.STRING)
    private SubscriptionsType type;

    public Subscriptions() {

    }

    public Subscriptions(String description, SubscriptionsType type, String stripeSubscriptionKey, Customers customers) {
        super();

        this.description = description;
        this.dateCreated = new Date();
        this.type = type;
        this.customers = customers;
        this.stripeSubscriptionKey = stripeSubscriptionKey;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStripeSubscriptionKey() {
        return stripeSubscriptionKey;
    }

    public SubscriptionsType getType() {
        return type;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Customers getCustomers() { return customers; }
}