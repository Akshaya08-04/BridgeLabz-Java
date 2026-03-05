package csvhandeling;
import java.io.*;
import java.util.*;

/*
 * Program Name : CSVToObject
 * Description  : Converts CSV rows into Student objects.
 */

class Student {
    int id;
    String name;
    int age;
    int marks;

    Student(int i, String n, int a, int m) {
        id = i; name = n; age = a; marks = m;
    }

    public String toString() {
        return id + " " + name + " " + age + " " + marks;
    }
}

public class CSVToObject {

    public static void main(String[] args) throws Exception {

        List<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();

        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");

            // Create object
            Student s = new Student(
                    Integer.parseInt(d[0]),
                    d[1],
                    Integer.parseInt(d[2]),
                    Integer.parseInt(d[3])
            );

            list.add(s);
        }

        // Print objects
        list.forEach(System.out::println);
    }
}

