package collectionstreams.generics;
/*
    Program Name : Personalized Meal Plan Generator

    Description :
    This program demonstrates the use of interfaces and
    generics. Different meal plans such as Vegetarian,
    Vegan, and Keto are generated using a generic Meal class.
*/

interface mealplan {

    // Abstract method
    void prepare();
}

class vegetarianmeal implements mealplan {
    public void prepare() {
        System.out.println("Preparing Vegetarian Meal");
    }
}

class veganmeal implements mealplan {
    public void prepare() {
        System.out.println("Preparing Vegan Meal");
    }
}

class ketomeal implements mealplan {
    public void prepare() {
        System.out.println("Preparing Keto Meal");
    }
}

class meal<T extends mealplan> {

    // Generic variable
    T plan;

    // Constructor
    meal(T plan) {
        this.plan = plan;
    }

    // Method to generate meal
    void generate() {
        plan.prepare();
    }
}

public class mealmain {
    public static void main(String[] args) {

        meal<vegetarianmeal> m1 = new meal<>(new vegetarianmeal());
        meal<veganmeal> m2 = new meal<>(new veganmeal());
        meal<ketomeal> m3 = new meal<>(new ketomeal());

        m1.generate();
        m2.generate();
        m3.generate();
    }
}
