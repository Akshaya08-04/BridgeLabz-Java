package csvhandeling;
import java.io.*;

/*
 * Program Name : LargeCSV
 * Description  : Reads large CSV file in chunks of 100 lines.
 * Input        : big.csv
 * Output       : Count of processed records
 */
public class LargeCSV {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("big.csv"));
        String line;
        int count = 0;

        // Read file line by line
        while ((line = br.readLine()) != null) {
            count++;

            // Process every 100 records
            if (count % 100 == 0) {
                System.out.println("Processed records: " + count);
            }
        }

        br.close();
        System.out.println("Total records processed: " + count);
    }
}
