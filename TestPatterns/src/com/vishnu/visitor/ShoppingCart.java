package com.vishnu.visitor;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Item> items;

    public static void main(String[] args){
        Book b1=new Book();
        Book b2=new Book();

        ShoppingCart sc=new ShoppingCart();
        sc.items=new ArrayList<Item>();
        sc.items.add(b1);
        sc.items.add(b2);

        System.out.println(sc.calculatePostage());
        System.out.println("");



    }



     public double calculatePostage() {
         Postage postage = new Postage();

         for(Item item: items) {

             item.accept(postage);

             }



         double postageVal = postage.getTotalPostage();

         return postageVal;

         }


}