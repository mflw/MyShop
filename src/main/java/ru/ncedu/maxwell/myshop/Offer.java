package ru.ncedu.maxwell.myshop;

/**
 * Created by maxwell on 20.11.2017.
 */
public class Offer {
    private String id;
    private String name;
    private String price;
    private String description;
    private int quantity = 1;
    public Offer(String id, String name, String price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getId() {return id;}
    public int getQuantity() {return quantity;}
    public int getPrice() {return Integer.parseInt(this.price);}
}
