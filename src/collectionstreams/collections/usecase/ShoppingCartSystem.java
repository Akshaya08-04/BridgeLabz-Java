package collectionstreams.collections.usecase;

import java.util.*;

public class ShoppingCartSystem {

    public static void main(String[] args) {

        Map<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Apple", 100);
        priceMap.put("Banana", 40);
        priceMap.put("Orange", 60);

        Map<String, Integer> cartOrder = new LinkedHashMap<>();
        cartOrder.put("Apple", 100);
        cartOrder.put("Banana", 40);
        cartOrder.put("Orange", 60);

        TreeMap<Integer, String> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : priceMap.entrySet()) {
            sortedByPrice.put(entry.getValue(), entry.getKey());
        }

        System.out.println(priceMap);
        System.out.println(cartOrder);
        System.out.println(sortedByPrice);
    }
}
