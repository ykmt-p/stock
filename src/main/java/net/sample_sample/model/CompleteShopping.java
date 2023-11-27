package net.sample_sample.model;

import java.io.Serializable;

public class CompleteShopping implements Serializable {
    private String user_id;
    private String product_name;
    private int quantity;

    public CompleteShopping() {
    }

    public CompleteShopping(String user_id, String product_name, int quantity) {
        this.user_id = user_id;
        this.product_name = product_name;
        this.quantity = quantity;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getQuantity() {
        return quantity;
    }
}
