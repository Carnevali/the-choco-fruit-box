package com.wine.gallery.models.orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wine.gallery.models.chocolates.Chocolates;
import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Entity
@Table(name="orders")
@JsonIgnoreProperties( ignoreUnknown = true )
public class OrdersItems implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_created", nullable=false)
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="orders_id")
    private Orders orders;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="chocolates_id")
    private Chocolates chocolates;

    @NotEmpty
    @Column(name="price", nullable=false)
    private Double price = 0.00;

    public OrdersItems() {

    }

    public OrdersItems(Orders orders, Chocolates chocolates, Double price) throws ValidationException {
        super();

        this.orders = orders;
        this.chocolates = chocolates;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Orders getOrders() {
        return orders;
    }

    public Chocolates getChocolates() {
        return chocolates;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Double getPrice() { return price; }
}