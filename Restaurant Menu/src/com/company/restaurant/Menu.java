package com.company.restaurant;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Menu {

    private LocalDate lastUpdated;
    private List<MenuItem> menuItems;
    private static List<String> orderOnMenu = Arrays.asList("appetizer", "entree", "dessert", "side", "other item");

    public Menu(List<MenuItem> items) {
        this.menuItems = new ArrayList<MenuItem>();
        items.forEach(this::addMenuItem);
        this.lastUpdated = LocalDate.now();
    }

    public Menu(List<MenuItem> items, LocalDate lastUpdated) {
        this.menuItems = new ArrayList<MenuItem>();
        items.forEach(this::addMenuItem);
        this.lastUpdated = lastUpdated;
    }

    public static List<String> getOrderOnMenu() {
        return orderOnMenu;
    }

    public void setOrderOnMenu(List<String> orderOnMenu) {
        this.orderOnMenu = orderOnMenu;
    }

    public void setOrderOnMenuFromArray(String[] orderOnMenu) {
        List<String> newOrderOnMenu = Arrays.asList(orderOnMenu);
        this.orderOnMenu = newOrderOnMenu;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        if(menuItems.contains(menuItem)) {
            System.out.println("" +menuItem+ " already exists. Item was not duplicated!\n");
        }
        else {
            menuItems.add(menuItem);
        }
    }

    public void removeMenuItem(MenuItem menuItem) {
        if (menuItems.contains(menuItem)) {
            menuItems.remove(menuItem);
        }
        else {
            System.out.println(menuItem+ " was not found in Menu");
        }

    }

    public void printMenu() {
        Collections.sort(menuItems);
        String Header = "";
        String displayedHeader = "";
        for (MenuItem menuItem : menuItems) {
            if (!Header.equals(menuItem.getCategory())) {
                Header = menuItem.getCategory();
                displayedHeader = "-=[ " + Header + "s ]=-";
                System.out.println(displayedHeader.toUpperCase());
            }
            System.out.println(menuItem.toMenuItemString());
        }
        System.out.println("///Menu was last updated " +this.getLastUpdated()+ "///");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Menu = {" +
                "lastUpdated=" + lastUpdated +
                ", menuItems=" + menuItems +
                "}";
    }
}
