package com.vishnu.visitor;

/**
 * Created by vishnu on 1/30/2016.
 */
public abstract class CD implements Item{
    @Override
    public void accept(PostageIntfce postage) {

        postage.visit(this);

    }


    public abstract boolean isSingle() ;
    public abstract double getWeight();
    public abstract int getNumOfDisks();
}
