package com.wine.gallery.models.orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wine.gallery.models.customers.Customers;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Entity
@Table(name="orders")
@JsonIgnoreProperties( ignoreUnknown = true )
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_created", nullable=false)
    private Date dateCreated;

    //We already have this inforation in our order, but I put here because we can avoid find by customers using the attribute order
    //because of this we can make more performance on the Hibernate. But we can use the customers inside the order, because
    //to create a new invoice we need of an oder
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="customers_id")
    private Customers customers;

    @NotEmpty
    @Column(name="closing_date", nullable=false)
    private Date closingDate;

    @Column(name="closed")
    private Boolean closed = Boolean.FALSE;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    public List<OrdersItems> items = new ArrayList<>();

    @NotEmpty
    @Column(name="total", nullable=false)
    private Double total = 0.00;

    public Orders() {

    }

    public Orders(Customers customers) throws ValidationException {
        super();

        this.customers = customers;
        this.dateCreated = new Date();
        this.closed = false;

        Calendar c = Calendar.getInstance();
        c.setTime(this.dateCreated);
        c.add(Calendar.DATE, +2);

        this.closingDate = c.getTime();
        calculateTotal();
    }

    public Long getId() {
        return id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public List<OrdersItems> getOrdersItems() { return items; }

    public Boolean getClosed() { return closed; }

    public Double getTotal() { return total; }

    public void closeOrder() {
        this.closed = true;
    }

    public Date generateClosingDateByCustomer() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.dateCreated);
        c.add(Calendar.DATE, this.customers.getClosingDay());

        return c.getTime();
    }

    public Double calculateTotal() {
        Double result = 0.00;

        for(OrdersItems item: this.items) {
            result += item.getPrice();
        }

        return result;
    }
}