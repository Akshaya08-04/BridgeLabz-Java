package collectionstreams.generics;
/*
    Program Name : AI-Driven Resume Screening System

    Description :
    This program demonstrates generics and abstract classes.
    Different job roles like Software Engineer, Data Scientist,
    and Product Manager are screened using a generic Resume class.
*/

abstract class jobrole {

    // Variable to store job role
    String name;

    // Constructor
    jobrole(String name) {
        this.name = name;
    }

    // Abstract screening method
    abstract void screen();
}

class softwareengineer extends jobrole {

    softwareengineer() {
        super("Software Engineer");
    }

    void screen() {
        System.out.println("Screening Software Engineer Resume");
    }
}

class datascientist extends jobrole {

    datascientist() {
        super("Data Scientist");
    }

    void screen() {
        System.out.println("Screening Data Scientist Resume");
    }
}

class productmanager extends jobrole {

    productmanager() {
        super("Product Manager");
    }

    void screen() {
        System.out.println("Screening Product Manager Resume");
    }
}

class resume<T extends jobrole> {

    // Generic variable
    T role;

    // Constructor
    resume(T role) {
        this.role = role;
    }

    // Method to process resume
    void process() {
        role.screen();
    }
}

public class resumemain {
    public static void main(String[] args) {

        resume<softwareengineer> r1 = new resume<>(new softwareengineer());
        resume<datascientist> r2 = new resume<>(new datascientist());
        resume<productmanager> r3 = new resume<>(new productmanager());

        r1.process();
        r2.process();
        r3.process();
    }
}
