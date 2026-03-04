package json.practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public int price;

    Car(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }
}

public class CarToJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("BMW", 5000000);

        String json = mapper.writeValueAsString(car);
        System.out.println(json);
    }
}
