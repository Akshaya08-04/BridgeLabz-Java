package csvhandeling;
import java.io.*;
import java.util.*;

/*
 * Program Name : ReadCSV
 * Description  : Reads a CSV file containing student details
 *                and prints each record in structured format.
 * Input        : CSV file name from user
 * Output       : Student details printed on console
 */
public class ReadCSV {

    public static void main(String[] args) throws Exception {

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Ask user for file name
        System.out.print("Enter CSV file name: ");
        String fileName = sc.nextLine();

        // Open file using BufferedReader
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;

        // Skip header line
        br.readLine();

        // Read file line by line
        while ((line = br.readLine()) != null) {

            // Split each line by comma
            String[] data = line.split(",");

            // Display data
            System.out.println("ID    : " + data[0]);
            System.out.println("Name  : " + data[1]);
            System.out.println("Age   : " + data[2]);
            System.out.println("Marks : " + data[3]);
            System.out.println("---------------------");
        }

        // Close resources
        br.close();
        sc.close();
    }
}
