package com.example.jpashop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.jpashop.domain.Book;
import com.example.jpashop.domain.Item;
import com.example.jpashop.service.ItemService;

@Controller
public class ItemController {
    @Autowired ItemService itemService;


    //상품 등록 폼
    @RequestMapping(value = "/items/new", method = RequestMethod.GET)
    public String createForm(){
        return "items/createItemForm";
    }

    //상품 등록
    @RequestMapping(value = "/items/new", method = RequestMethod.POST)
    public String create(Book item){
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model){
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    //상품 수정 폼
    @RequestMapping(value = "/items/{itemId}/edit", method = RequestMethod.GET)
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model){
        Item item = itemService.findOne(itemId);
        model.addAttribute("item", item);
        return "items/updateItemForm";
    }

    //상품 수정
    @RequestMapping(value = "/items/{itemId}/edit", method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("item") Book item){
        
        itemService.saveItem(item);
        return "redirect:/items";
    }

}