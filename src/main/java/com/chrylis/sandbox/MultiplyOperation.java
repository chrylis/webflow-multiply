package com.chrylis.sandbox;

import java.io.Serializable;

public class MultiplyOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    int mult1, mult2;

    public int getMult1() {
        return mult1;
    }

    public void setMult1(int mult1) {
        this.mult1 = mult1;
    }

    public int getMult2() {
        return mult2;
    }

    public void setMult2(int mult2) {
        this.mult2 = mult2;
    }

    int product;

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }
}
