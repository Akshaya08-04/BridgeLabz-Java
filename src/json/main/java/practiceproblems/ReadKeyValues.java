package json.practiceproblems;

import com.fasterxml.jackson.databind.*;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

public class ReadKeyValues {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        InputStream is = ReadKeyValues.class
                .getClassLoader()
                .getResourceAsStream("users.json");

        JsonNode root = mapper.readTree(is);

        for (JsonNode node : root) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            System.out.println("----");
        }
    }
}
