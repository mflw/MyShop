package ru.ncedu.maxwell.myshop;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by maxwell on 20.11.2017.
 */
public class ShoppingCart implements Serializable {
    private ArrayList<Offer> cart;
    public ShoppingCart() {
        try {
            FileInputStream fis = new FileInputStream("myCart.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            cart = (ArrayList<Offer>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            cart = new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
    void saveCart() {
        try {
            FileOutputStream fos = new FileOutputStream("myCart.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cart);
            oos.close();

        } catch (IOException e) {
            File cartFile = new File("myCart.ser");
            //System.out.println("ошибка чтения");
            try {
                cartFile.createNewFile();
                this.saveCart();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }
}


