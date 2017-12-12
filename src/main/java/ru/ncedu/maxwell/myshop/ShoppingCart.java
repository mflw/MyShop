package ru.ncedu.maxwell.myshop;

import java.util.ArrayList;

/**
 * Created by maxwell on 20.11.2017.
 */
public class ShoppingCart {
    private ArrayList<Offer> cart;
    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    void addItem(Offer offer) {
    cart.add(offer);
    }

    void deleteItem(int index) {cart.remove(index);}
    void setQuantity(int index, int quantity) {cart.get(index).setQuantity(quantity);}
    void showCart() {
    if (cart.size()==0) {
        System.out.println("В вашей корзине еще нет товаров.");
        return;
    }
        int sum = 0;
        System.out.println("Введите номер товара для изменения. ");
        int i=0;
        for (Offer offer:cart) {
            i++;
            sum+=offer.getQuantity()*offer.getPrice();
            System.out.print("("+i+")  ");
            Menu.catalog.showOffer(offer.getId());
            System.out.println("    "+offer.getQuantity()+"шт");
            System.out.println("------------------");
        }
        System.out.println("             "+sum+"$");
    }
}


