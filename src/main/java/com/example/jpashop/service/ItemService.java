package com.example.jpashop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpashop.domain.Item;
import com.example.jpashop.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
    @Autowired
    ItemRepository ItemRepository;

    public void saveItem(Item item){
        ItemRepository.save(item);
    }

    public List<Item> findItems(){
        return ItemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return ItemRepository.findOne(itemId);
    }
}