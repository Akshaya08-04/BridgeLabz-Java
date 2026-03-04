package json.practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

/*
 * Car POJO class
 */
class Cars {
    public String brand;
    public int price;

    public Cars(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }
}

/*
 * Problem:
 * Convert a list of Java objects into a JSON array
 */
public class ListToJsonArray {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        /*
         * Create list of Java objects
         */
        List<Car> cars = Arrays.asList(
                new Car("BMW", 5000000),
                new Car("Audi", 6000000)
        );

        /*
         * Convert list into JSON array
         */
        String jsonArray = mapper.writeValueAsString(cars);
        System.out.println(jsonArray);
    }
}
