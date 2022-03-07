package com.example.order.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card extends BaseEntity {

    private String cardHolder;
    private String number;
    private String expires;
    private String ccv;
    private Float balance;

    public Card() {
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", expires='" + expires + '\'' +
                ", ccv='" + ccv + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return getId().equals(card.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
