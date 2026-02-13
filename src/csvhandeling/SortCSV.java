package csvhandeling;
import java.io.*;
import java.util.*;

/*
 * Program Name : SortCSV
 * Description  : Sorts employees by salary (descending).
 */
public class SortCSV {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        br.readLine();

        List<String[]> list = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            list.add(line.split(","));
        }

        // Sort using lambda
        list.sort((a, b) ->
                Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3]))
        );

        // Print top 5
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i)[1] + " -> " + list.get(i)[3]);
        }
    }
}
