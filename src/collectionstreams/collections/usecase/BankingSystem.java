package collectionstreams.collections.usecase;

import java.util.*;

class Withdrawal {
    int accountNumber;
    int amount;

    Withdrawal(int accountNumber, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        Map<Integer, Integer> accounts = new HashMap<>();
        accounts.put(1001, 5000);
        accounts.put(1002, 8000);
        accounts.put(1003, 3000);

        TreeMap<Integer, Integer> sortedByBalance = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            sortedByBalance.put(entry.getValue(), entry.getKey());
        }

        Queue<Withdrawal> queue = new LinkedList<>();
        queue.add(new Withdrawal(1001, 2000));
        queue.add(new Withdrawal(1003, 1000));
        queue.add(new Withdrawal(1002, 4000));

        while (!queue.isEmpty()) {
            Withdrawal w = queue.remove();
            int balance = accounts.get(w.accountNumber);
            if (balance >= w.amount) {
                accounts.put(w.accountNumber, balance - w.amount);
            }
        }

        System.out.println(accounts);
        System.out.println(sortedByBalance);
    }
}
