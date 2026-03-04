package json.practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Problem:
 * Validate whether a JSON string is valid or not
 * using Jackson ObjectMapper
 */
public class ValidateJson {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        String json = "{ \"name\": \"Akshaya\", \"age\": 22 }";

        try {
            /*
             * If parsing is successful,
             * JSON structure is valid
             */
            mapper.readTree(json);
            System.out.println("Valid JSON");
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}
