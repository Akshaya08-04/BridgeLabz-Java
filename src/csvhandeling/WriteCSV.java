package csvhandeling;
import java.io.*;
import java.util.*;

/*
 * Program Name : WriteCSV
 * Description  : Writes employee details into a CSV file.
 * Input        : Employee details from user
 * Output       : employees.csv file created
 */
public class WriteCSV {

    public static void main(String[] args) throws Exception {

        // Create file writer
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"));

        // Write header
        bw.write("ID,Name,Department,Salary\n");

        Scanner sc = new Scanner(System.in);

        // Take 5 records from user
        for (int i = 1; i <= 5; i++) {

            System.out.println("Enter ID, Name, Dept, Salary:");
            String record = sc.nextLine();

            // Write record to file
            bw.write(record + "\n");
        }

        // Close file
        bw.close();
        sc.close();

        System.out.println("CSV file created successfully!");
    }
}

