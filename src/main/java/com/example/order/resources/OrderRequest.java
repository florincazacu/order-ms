package com.example.order.resources;

import com.example.order.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
    private Long customerId;
    private Long addressId;
    private Long cardId;
    private List<Item> orderedItems = new ArrayList<>();

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public List<Item> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<Item> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "customerId=" + customerId +
                ", addressId=" + addressId +
                ", cardId=" + cardId +
                ", orderedItems=" + orderedItems +
                '}';
    }
}
