package collectionstreams.collections.queueinterface;
import java.util.*;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int n = 5;
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String curr = queue.remove();
            System.out.println(curr);
            queue.add(curr + "0");
            queue.add(curr + "1");
        }
    }
}

