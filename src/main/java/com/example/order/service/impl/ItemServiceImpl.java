package com.example.order.service.impl;

import com.example.order.entities.Item;
import com.example.order.repositories.ItemRepository;
import com.example.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Set<Item> findAll() {
        return null;
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item save(Item entity) {
        return itemRepository.save(entity);
    }

    @Override
    public void delete(Item entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void update(Long aLong, Item entity) {

    }
}
