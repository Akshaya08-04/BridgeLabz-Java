package json.practiceproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

/*
 * Problem:
 * Parse JSON file and print only those records
 * where age is greater than 25
 *
 * JSON file is read from src/main/resources
 */
public class FilterJsonByAge {

    public static void main(String[] args) throws Exception {

        /*
         * ObjectMapper is used to parse JSON
         */
        ObjectMapper mapper = new ObjectMapper();

        /*
         * Load users.json from classpath (resources folder)
         * This works in Maven, IntelliJ, and JAR execution
         */
        InputStream inputStream = FilterJsonByAge.class
                .getClassLoader()
                .getResourceAsStream("users.json");

        /*
         * Safety check: if file not found
         */
        if (inputStream == null) {
            System.out.println("users.json file not found in resources folder");
            return;
        }

        /*
         * Parse JSON array
         */
        JsonNode rootNode = mapper.readTree(inputStream);

        /*
         * Filter records where age > 25
         */
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                System.out.println(
                        "Name: " + node.get("name").asText() +
                                ", Email: " + node.get("email").asText() +
                                ", Age: " + node.get("age").asInt()
                );
            }
        }
    }
}