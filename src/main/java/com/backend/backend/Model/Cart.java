package com.backend.backend.Model;

public class Cart {
    private static Cart cosCumparaturi=new Cart();

    //default constructor
    private Cart(){

    }

    //get instance for class Cart
    public static Cart getInstance(){
        return cosCumparaturi;
    }
}
