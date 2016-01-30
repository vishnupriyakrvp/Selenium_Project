package com.vishnu.visitor;


public class Postage implements PostageIntfce {

    private double totalPostageForCart;
    public double getTotalPostage() {

        return totalPostageForCart;

        }

    @Override
    public void visit(Book book) {

        if(book.getPrice() < 10.0) {

            totalPostageForCart += book.getWeight();

        } else {

            totalPostageForCart += book.getWeight() * 2;

        }

    }

    @Override
    public void visit(CD cd) {


        if(cd.isSingle()) {

            totalPostageForCart += cd.getWeight();

        } else {

            totalPostageForCart += cd.getWeight() * cd.getNumOfDisks();

        }

    }

    @Override
    public void visit(DVD dvd) {

        if(dvd.isSingle()) {

            totalPostageForCart += dvd.getWeight() + 10;

        } else {

            totalPostageForCart += (dvd.getWeight() + 10) * dvd.getNumOfDisks();

        }

    }
}
