package csvhandeling;
import java.io.*;
import java.util.*;

/*
 * Program Name : MergeCSV
 * Description  : Merges two CSV files based on ID.
 * Input        : students1.csv and students2.csv
 * Output       : merged.csv
 */
public class MergeCSV {

    public static void main(String[] args) throws Exception {

        // Map to store first file data using ID as key
        Map<String, String[]> map = new HashMap<>();

        // Read first CSV file
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        br1.readLine(); // skip header
        String line;

        while ((line = br1.readLine()) != null) {
            String[] data = line.split(",");
            map.put(data[0], data);
        }

        // Read second CSV file
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        br2.readLine(); // skip header

        // Create merged output file
        BufferedWriter bw = new BufferedWriter(new FileWriter("merged.csv"));
        bw.write("ID,Name,Age,Marks,Grade\n");

        // Merge based on ID
        while ((line = br2.readLine()) != null) {
            String[] data2 = line.split(",");
            String[] data1 = map.get(data2[0]);

            bw.write(
                    data1[0] + "," +
                            data1[1] + "," +
                            data1[2] + "," +
                            data2[1] + "," +
                            data2[2] + "\n"
            );
        }

        // Close all files
        br1.close();
        br2.close();
        bw.close();

        System.out.println("CSV files merged successfully.");
    }
}
