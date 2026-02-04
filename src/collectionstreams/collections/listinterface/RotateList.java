package collectionstreams.collections.listinterface;
import java.util.*;

public class RotateList {
    static <T> void rotate(List<T> list, int k) {
        int n = list.size();
        k = k % n;
        List<T> temp = new ArrayList<>();

        for (int i = k; i < n; i++) temp.add(list.get(i));
        for (int i = 0; i < k; i++) temp.add(list.get(i));

        for (int i = 0; i < n; i++) list.set(i, temp.get(i));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotate(list, 2);
        System.out.println(list);
    }
}

