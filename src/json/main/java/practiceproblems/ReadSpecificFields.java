package json.practiceproblems;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

/*
 * Problem:
 * Read a JSON file and extract only specific fields
 * such as name and email
 *
 * Input: users.json (array of objects)
 * Output: Print name and email
 */
public class ReadSpecificFields {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        /*
         * Read JSON file into JsonNode tree
         */
        JsonNode rootNode = mapper.readTree(new File("users.json"));

        /*
         * Iterate over JSON array
         */
        for (JsonNode node : rootNode) {
            String name = node.get("name").asText();
            String email = node.get("email").asText();

            System.out.println("Name: " + name + ", Email: " + email);
        }
    }
}