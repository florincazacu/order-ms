package com.example.order.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    private Card card;

        @OneToMany(targetEntity = Item.class, fetch = FetchType.EAGER)
//    @OneToMany(targetEntity = Item.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "order_items",
            joinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
//    @Transient
    private List<Item> items;

    private Date date = Calendar.getInstance().getTime();

    private float total;

    public Order() {
    }

    public Order(Customer customer, Address address, Card card,
                 List<Item> items, Date date, float total) {
        this.customer = customer;
        this.address = address;
        this.card = card;
        this.items = items;
        this.date = date;
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "customer=" + customer +
                ", items=" + items +
                ", date=" + date +
                '}';
    }
}
