package collectionstreams.collections.listinterface;

import java.util.*;

public class NthFromEnd {
    static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        for (int i = 0; i < n; i++) second.next();

        while (second.hasNext()) {
            first.next();
            second.next();
        }

        return first.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(findNthFromEnd(list, 2));
    }
}
