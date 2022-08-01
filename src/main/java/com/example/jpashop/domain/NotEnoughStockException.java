package com.example.jpashop.domain;

public class NotEnoughStockException extends Exception{
    public NotEnoughStockException(){

    }
    public NotEnoughStockException(String str){
        super(str);
        
    }
}
