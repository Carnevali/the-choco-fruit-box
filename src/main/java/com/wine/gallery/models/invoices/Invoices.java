package com.wine.gallery.models.invoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wine.gallery.models.orders.Orders;
import com.wine.gallery.models.customers.Customers;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Entity
@Table(name="invoices")
@JsonIgnoreProperties( ignoreUnknown = true )
public class Invoices implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="customers_id")
    private Customers customers;

    @NotEmpty
    @Column(name="due_date", nullable=false)
    private Date dueDate;

    @Column(name="date_created", nullable=false)
    private Date dateCreated;

    @NotEmpty
    @Column(name="total", nullable=false)
    private Double total = 0.00;

    @NotEmpty
    @Column(name="stripe_key", nullable=false)
    private String stripeKey;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="orders_id")
    private Orders orders;

    public Invoices() {

    }

    public Invoices(Date dueDate, Double total, String stripeKey, Orders orders) throws ValidationException {
        super();

        this.customers = orders.getCustomers();
        this.dateCreated = new Date();
        this.dueDate = dueDate;
        this.stripeKey = stripeKey;

        //In the future if we need to create a refund we can create a type or take out this validation
        if (total < 0) {
            new ValidationException("Invalid total. Your invoice can't be negative");
        } else {
            this.total = total;
        }

        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Double getTotal() {
        return total;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getStripeKey() { return stripeKey; }

    public Orders getOrders() { return orders; }
}