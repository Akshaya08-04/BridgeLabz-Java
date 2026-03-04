package json.practiceproblems;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/*
 * Problem:
 * Merge two JSON objects into a single JSON object
 */
public class MergeJsonObjects {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        /*
         * First JSON object
         */
        ObjectNode json1 = mapper.createObjectNode();
        json1.put("name", "Akshaya");

        /*
         * Second JSON object
         */
        ObjectNode json2 = mapper.createObjectNode();
        json2.put("email", "akshaya@gmail.com");

        /*
         * Merge json2 into json1
         */
        json1.setAll(json2);

        System.out.println(json1);
    }
}