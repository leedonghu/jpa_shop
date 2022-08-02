package com.example.jpashop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpashop.domain.Item;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.NotEnoughStockException;
import com.example.jpashop.service.ItemService;
import com.example.jpashop.service.MemberService;
import com.example.jpashop.service.OrderService;

@Controller
public class OrderController {
    
    @Autowired OrderService orderService;
    @Autowired MemberService memberService;
    @Autowired ItemService itemService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String createForm(Model model){
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    public String order(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId, @RequestParam("count") int count) throws NotEnoughStockException{
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    
}