package collectionstreams.generics;
/*
    Program Name : University Course Management System

    Description :
    This program demonstrates the use of generic classes
    and abstract classes. Different course types such as
    Exam, Assignment, and Research courses are managed
    using a generic Course class.
*/

abstract class coursetype {

    // Variable to store course name
    String name;

    // Constructor
    coursetype(String name) {
        this.name = name;
    }

    // Abstract evaluation method
    abstract void evaluate();
}

class examcourse extends coursetype {

    examcourse(String name) {
        super(name);
    }

    void evaluate() {
        System.out.println(name + " evaluated using exam");
    }
}

class assignmentcourse extends coursetype {

    assignmentcourse(String name) {
        super(name);
    }

    void evaluate() {
        System.out.println(name + " evaluated using assignment");
    }
}

class researchcourse extends coursetype {

    researchcourse(String name) {
        super(name);
    }

    void evaluate() {
        System.out.println(name + " evaluated using research");
    }
}

class course<T extends coursetype> {

    // Generic variable
    T course;

    // Constructor
    course(T course) {
        this.course = course;
    }

    // Method to show evaluation type
    void showEvaluation() {
        course.evaluate();
    }
}

public class universitymain {
    public static void main(String[] args) {

        course<examcourse> c1 = new course<>(new examcourse("Maths"));
        course<assignmentcourse> c2 = new course<>(new assignmentcourse("Java"));
        course<researchcourse> c3 = new course<>(new researchcourse("AI"));

        c1.showEvaluation();
        c2.showEvaluation();
        c3.showEvaluation();
    }
}
