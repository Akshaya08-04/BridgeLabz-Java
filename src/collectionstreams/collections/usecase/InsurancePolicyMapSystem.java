package collectionstreams.collections.usecase;

import java.util.*;
import java.time.*;

class Policy {
    int policyNumber;
    String policyHolder;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    Policy(int policyNumber, String policyHolder, LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    public String toString() {
        return policyNumber + " " + policyHolder + " " + expiryDate + " " + coverageType;
    }
}

public class InsurancePolicyMapSystem {

    static void expiringSoon(Map<Integer, Policy> map) {
        LocalDate today = LocalDate.now();
        for (Policy p : map.values()) {
            if (!p.expiryDate.isBefore(today) && p.expiryDate.isBefore(today.plusDays(30)))
                System.out.println(p);
        }
        System.out.println();
    }

    static void byPolicyHolder(Map<Integer, Policy> map, String name) {
        for (Policy p : map.values())
            if (p.policyHolder.equals(name))
                System.out.println(p);
        System.out.println();
    }

    static void removeExpired(Map<Integer, Policy> map) {
        Iterator<Map.Entry<Integer, Policy>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().expiryDate.isBefore(LocalDate.now()))
                it.remove();
        }
    }

    public static void main(String[] args) {

        Policy p1 = new Policy(201, "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy(202, "Bob", LocalDate.now().plusDays(40), "Auto", 8000);
        Policy p3 = new Policy(203, "Alice", LocalDate.now().minusDays(5), "Home", 6000);

        Map<Integer, Policy> hashMap = new HashMap<>();
        Map<Integer, Policy> linkedHashMap = new LinkedHashMap<>();
        Map<LocalDate, Policy> treeMap = new TreeMap<>();

        hashMap.put(p1.policyNumber, p1);
        hashMap.put(p2.policyNumber, p2);
        hashMap.put(p3.policyNumber, p3);

        linkedHashMap.putAll(hashMap);

        treeMap.put(p1.expiryDate, p1);
        treeMap.put(p2.expiryDate, p2);
        treeMap.put(p3.expiryDate, p3);

        System.out.println(hashMap.get(201));
        System.out.println();

        expiringSoon(hashMap);
        byPolicyHolder(hashMap, "Alice");

        removeExpired(hashMap);
        System.out.println(hashMap.values());
        System.out.println();

        System.out.println(linkedHashMap.values());
        System.out.println(treeMap.values());
    }
}
