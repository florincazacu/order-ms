package com.example.order.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.validator.routines.EmailValidator;
import javax.ws.rs.BadRequestException;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String email;
    private String firstName;
    private String lastName;

    @OneToMany(targetEntity=Address.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_address",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id", referencedColumnName = "id")})
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(targetEntity=Card.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_card",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "card_id", referencedColumnName = "id")}
    )
    private Card card;

//    @OneToMany(targetEntity=Order.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "customer_orders",
//            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")}
//    )
//    private List<Order> orders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, List<Address> addresses, Card card) {

        if (!EmailValidator.getInstance().isValid(email)) {
            throw new BadRequestException(String.format("%s is not a valid email address", email));
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
        this.card = card;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new BadRequestException(String.format("%s is not a valid email address", email));
        }
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + email + '\'' +
                ", addresses=" + addresses +
                ", card=" + card +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!getId().equals(customer.getId())) return false;
        return getEmail() != null ? getEmail().equals(customer.getEmail()) : customer.getEmail() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
