package csvhandeling;
import java.io.*;

/*
 * Program Name : FilterCSV
 * Description  : Displays students who scored above 80.
 */
public class FilterCSV {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine(); // skip header

        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");
            int marks = Integer.parseInt(data[3]);

            // Check condition
            if (marks > 80) {
                System.out.println(data[1] + " -> " + marks);
            }
        }
        br.close();
    }
}
