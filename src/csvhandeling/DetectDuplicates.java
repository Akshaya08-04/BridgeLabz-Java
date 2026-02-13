package csvhandeling;
import java.io.*;
import java.util.*;

/*
 * Program Name : DetectDuplicates
 * Description  : Detects duplicate records using ID column.
 * Input        : students.csv
 * Output       : Duplicate rows printed
 */
public class DetectDuplicates {

    public static void main(String[] args) throws Exception {

        Set<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine(); // skip header
        String line;

        while ((line = br.readLine()) != null) {
            String id = line.split(",")[0];

            // If ID already exists
            if (!set.add(id)) {
                System.out.println("Duplicate Record: " + line);
            }
        }

        br.close();
    }
}
