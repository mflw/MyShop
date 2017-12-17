package ru.ncedu.maxwell.myshop;

import java.util.Scanner;

/**
 * Created by maxwell on 26.11.2017.
 */
public class Menu {
    static Catalog catalog;
    private Scanner scanner;
    private String input;

    public Menu(){
        scanner = new Scanner(System.in, "Cp866"); //windows
//        scanner = new Scanner(System.in); //ide
    }

    void mainMenu() {
        catalog = new Catalog();
        System.out.println("Добро пожаловать в myshop!\nПожалуйста, введите номер пункта меню:\n1  Каталог\n2  Корзина\nв  Выход");
        System.out.print(">>");
        input = scanner.next();
        switch (input) {
            case "1":
                this.chooseCategory();
                break;
            case "2":
                this.menuCart();
                break;
            case "в":
                this.exit();
        }
    }

    void chooseCategory() {
        catalog.showCatalog();
        System.out.println("------------------");
        input = this.standartMenu();
        this.chooseOffers(input);
    }

    void chooseOffers(String id) {
        catalog.showCategory(id);
        System.out.println("------------------");
        input = this.standartMenu();
        showChosenOffer(input);
    }
    void showChosenOffer(String id) {
        Offer offer = catalog.showOffer(id);
        System.out.println("------------------");
        System.out.println("к Купить");
        input = this.standartMenu();
        if (input.equals("к")) {
            System.out.println("Сколько?");
            int quantity = scanner.nextInt();
            offer.setQuantity(quantity);
            MyShop.myCart.addItem(offer);
            System.out.println("Товар добавлен в корзину.");
            this.mainMenu();
        }

    }

    void menuCart(){
        MyShop.myCart.showCart();
        //todo login
        input = this.standartMenu();
        System.out.println("Что сделать с этим товаром?\nу Удалить.\nи Изменить количество");
        String command = scanner.next();
        if (command.equals("у")) {
            MyShop.myCart.deleteItem(Integer.parseInt(input)-1);
            this.menuCart();
        }
        System.out.println("Сколько?"); //todo случай если корзина пустая
        int quantity = scanner.nextInt();
        if (command.equals("и")) MyShop.myCart.setQuantity(Integer.parseInt(input)-1, quantity);
        this.menuCart();
    }

    void registration() { // todo registration
        String login;
        String password;
        System.out.println("Регистрация нового пользователя.");
        System.out.println("Введите логин:");
        login = scanner.next();
        login.matches("");
    }
    void exit() {
        MyShop.myCart.saveCart();
        System.exit(0);
    }

    private String standartMenu() {
        System.out.println("г  Главное меню");
        System.out.println("в  Выход");
        System.out.print(">>");
        input = scanner.next();
        if (input.equals("в")) this.exit();
        if (input.equals("г")) this.mainMenu();
        return input;
    }
}
