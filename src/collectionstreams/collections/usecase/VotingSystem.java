package collectionstreams.collections.usecase;

import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {

        Map<String, Integer> voteMap = new HashMap<>();
        voteMap.put("Alice", 120);
        voteMap.put("Bob", 150);
        voteMap.put("Carol", 100);

        Map<String, Integer> insertionOrderMap = new LinkedHashMap<>();
        insertionOrderMap.put("Alice", 120);
        insertionOrderMap.put("Bob", 150);
        insertionOrderMap.put("Carol", 100);

        Map<String, Integer> sortedResultMap = new TreeMap<>(voteMap);

        System.out.println(voteMap);
        System.out.println(insertionOrderMap);
        System.out.println(sortedResultMap);
    }
}

