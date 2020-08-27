package com.company.restaurant;
import java.awt.*;
import java.awt.Menu;
import java.awt.MenuItem;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {
        java.awt.MenuItem primeRib = new java.awt.MenuItem("Prime Rib", "$15.50" , "A Sirloin Steak served with a baked potato and one additional side.", "entree", false );
        java.awt.MenuItem keylimePie = new java.awt.MenuItem("Keylime Pie", "$4.50", "A sweet but tangy treat topped with whipped cream.", "dessert", false );
        java.awt.MenuItem bloomingOnion = new java.awt.MenuItem("Blooming Onion", "$8.00", "It's bloomtastic... but don't tell the aussies.", "appetizer", false);
        java.awt.MenuItem greenBeans = new java.awt.MenuItem("Green Beans", "Free with entree, 50\u00A2 without.", "Beeaaansss!!", "side", false);
        List<java.awt.MenuItem> itemList = Arrays.asList(primeRib, primeRib, keylimePie, bloomingOnion, greenBeans);

        java.awt.Menu theMenu = new Menu(itemList);
        theMenu.printMenu();
        System.out.println("***printMenuItem method called on a menu item***");
        primeRib.printItem();

    }

    public static java.awt.MenuItem copyMenuItem(java.awt.MenuItem menuItem) {
        java.awt.MenuItem newItem = new MenuItem(menuItem.getItemName(),
                menuItem.getPrice(),
                menuItem.getDescription(),
                menuItem.getCategory(),
                menuItem.isNew() );
        return newItem;
    }
}