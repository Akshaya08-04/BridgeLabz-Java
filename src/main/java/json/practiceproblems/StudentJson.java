package json.practiceproblems;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Student {
    public String name;
    public int age;
    public List<String> subjects;

    Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}

public class StudentJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Student student = new Student(
                "Akshaya",
                22,
                Arrays.asList("Java", "SQL", "JSON")
        );

        String json = mapper.writeValueAsString(student);
        System.out.println(json);
    }
}