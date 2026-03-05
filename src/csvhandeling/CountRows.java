package csvhandeling;
import java.io.*;

/*
 * Program Name : CountRows
 * Description  : Counts number of records in CSV file.
 * Input        : CSV file
 * Output       : Total number of rows
 */
public class CountRows {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));

        int count = 0;

        // Skip header
        br.readLine();

        // Count remaining lines
        while (br.readLine() != null) {
            count++;
        }

        System.out.println("Total Records: " + count);
        br.close();
    }
}

