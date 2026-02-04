package collectionstreams.generics;
/*
    Program Name : Dynamic Online Marketplace

    Description :
    This program demonstrates generic methods and inheritance.
    Different product types like Book, Clothing, and Gadget
    are handled using a common Product class. A generic
    method is used to apply discounts dynamically.
*/

class product {

    // Variables to store product details
    String name;
    double price;

    // Constructor
    product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method to display product details
    void display() {
        System.out.println(name + " Price: " + price);
    }
}

class book extends product {
    book(String name, double price) {
        super(name, price);
    }
}

class clothing extends product {
    clothing(String name, double price) {
        super(name, price);
    }
}

class gadget extends product {
    gadget(String name, double price) {
        super(name, price);
    }
}

class discount {

    // Generic method to apply discount
    static <T extends product> void applyDiscount(T p, double percent) {

        // Calculating discounted price
        p.price = p.price - (p.price * percent / 100);

        // Displaying updated price
        p.display();
    }
}

public class marketmain {
    public static void main(String[] args) {

        book b = new book("Java Book", 500);
        clothing c = new clothing("T-Shirt", 800);
        gadget g = new gadget("Mobile", 15000);

        // Applying discounts
        discount.applyDiscount(b, 10);
        discount.applyDiscount(c, 20);
        discount.applyDiscount(g, 5);
    }
}

