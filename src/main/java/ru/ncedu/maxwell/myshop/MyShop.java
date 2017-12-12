package ru.ncedu.maxwell.myshop;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by maxwell on 20.11.2017.
 */
public class MyShop {

    static ShoppingCart myCart = new ShoppingCart();


    public static void main(String arqs[]) throws IOException, ParserConfigurationException {

        Menu menu = new Menu();
        ShoppingCart myCart = new ShoppingCart();
        menu.mainMenu();


        }

    }

