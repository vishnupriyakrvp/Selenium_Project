package com.vishnu.visitor;

public class Book implements Item{
	 private double price;
	 private double weight;
	 
	 public void accept(PostageIntfce postage) {
	   postage.visit(this);
	 }
	 public double getPrice() {
	   return price;
	 }
	 public double getWeight() {
	   return weight;
	 }
	}
	