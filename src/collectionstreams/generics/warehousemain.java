package collectionstreams.generics;
/*
    Program Name : Smart Warehouse Management System

    Description :
    This program demonstrates Java Generics using a bounded
    type parameter. Different warehouse items like Electronics,
    Groceries, and Furniture are stored safely using a generic
    Storage class while maintaining type safety.
*/

abstract class warehouseitem {

    // Variable to store item name
    String name;

    // Constructor to initialize item name
    warehouseitem(String name) {
        this.name = name;
    }

    // Abstract method
    abstract void display();
}

class electronics extends warehouseitem {

    electronics(String name) {
        super(name);
    }

    void display() {
        System.out.println("Electronics Item: " + name);
    }
}

class groceries extends warehouseitem {

    groceries(String name) {
        super(name);
    }

    void display() {
        System.out.println("Grocery Item: " + name);
    }
}

class furniture extends warehouseitem {

    furniture(String name) {
        super(name);
    }

    void display() {
        System.out.println("Furniture Item: " + name);
    }
}

class storage<T extends warehouseitem> {

    // Generic variable
    T item;

    // Constructor
    storage(T item) {
        this.item = item;
    }

    // Method to display item
    void showItem() {
        item.display();
    }
}

public class warehousemain {
    public static void main(String[] args) {

        // Creating objects using generic class
        storage<electronics> s1 = new storage<>(new electronics("Laptop"));
        storage<groceries> s2 = new storage<>(new groceries("Rice"));
        storage<furniture> s3 = new storage<>(new furniture("Chair"));

        // Displaying items
        s1.showItem();
        s2.showItem();
        s3.showItem();
    }
}
