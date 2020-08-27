package com.company.restaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class MenuItem implements Comparable<MenuItem>{
    private String itemName;
    private String price;
    private final LocalDate dateAdded;
    private String description;
    private String category;
    private boolean isNew;

    public MenuItem(boolean isNew) {
        this.itemName = "";
        this.price = "";
        this.description = "";
        this.category = "";
        this.dateAdded = LocalDate.now();
        this.isNew = isNew;
    }

    public MenuItem(String itemName, String price, String description, String category, boolean isNew) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.category = category;
        this.dateAdded = LocalDate.now();
        this.isNew = isNew;
    }

    public MenuItem() {
        this.itemName = "";
        this.price = "";
        this.description = "";
        this.category = "";
        this.dateAdded = LocalDate.now();
        this.isNew = false;
    }

    public MenuItem(String itemName, String price, String description, String category) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.category = category;
        this.dateAdded = LocalDate.now();
        this.isNew = false;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void printItem() {
        System.out.println(toMenuItemString());
    }

    public String toMenuItemString() {
        String isItemNew = this.isNew() ? "New!!! " : "";
        return isItemNew +this.getItemName()+ " - " +this.getPrice()+ "\n"
                +this.getDescription()+ "\n";
    }


    @Override
    public String toString() {
        return  "MenuItem = {" +
                "itemName = '" +itemName+ "'" +
                ", price = '" +price+ "'" +
                ", dateAdded = '" +dateAdded+ "'" +
                ", description = '" +description+ "'" +
                ", category = '" +category+ "'" +
                ", isNew = '" +isNew+ "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return isNew() == menuItem.isNew() &&
                getItemName().equals(menuItem.getItemName()) &&
                getPrice().equals(menuItem.getPrice()) &&
                getDateAdded().equals(menuItem.getDateAdded()) &&
                getDescription().equals(menuItem.getDescription()) &&
                getCategory().equals(menuItem.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemName(), getPrice(), getDateAdded(), getDescription(), getCategory(), isNew());
    }

    @Override
    public int compareTo(MenuItem menuItem) {
        List<String> orderOnMenu = Menu.getOrderOnMenu();
        String lowerCaseCaller = this.getCategory().toLowerCase();
        String lowerCaseParameter = menuItem.getCategory().toLowerCase();
        if(orderOnMenu.contains(lowerCaseCaller) && orderOnMenu.contains(lowerCaseParameter)) {
            return orderOnMenu.indexOf(lowerCaseCaller) > orderOnMenu.indexOf(lowerCaseParameter) ? 1 : lowerCaseCaller.equals(lowerCaseParameter) ? 0 : -1;
        }
        else {
            return 1;
        }
    }
}