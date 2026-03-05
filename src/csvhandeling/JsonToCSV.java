package csvhandeling;
import java.io.*;

/*
 * Program Name : JsonToCSV
 * Description  : Converts JSON file to CSV format.
 * Input        : students.json
 * Output       : students.csv
 */
public class JsonToCSV {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.json"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"));

        // Write CSV header
        bw.write("ID,Name,Age\n");

        String line;

        while ((line = br.readLine()) != null) {

            // Remove symbols
            line = line.replaceAll("[{}\"]", "");

            // Split JSON fields
            String[] data = line.split(",");

            // Write CSV row
            bw.write(
                    data[0].split(":")[1] + "," +
                            data[1].split(":")[1] + "," +
                            data[2].split(":")[1] + "\n"
            );
        }

        br.close();
        bw.close();

        System.out.println("JSON converted to CSV.");
    }
}

