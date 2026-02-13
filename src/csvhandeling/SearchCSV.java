package csvhandeling;
import java.io.*;
import java.util.*;

/*
 * Program Name : SearchCSV
 * Description  : Searches employee by name.
 */
public class SearchCSV {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        br.readLine();

        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data[1].equalsIgnoreCase(name)) {
                System.out.println("Department: " + data[2]);
                System.out.println("Salary    : " + data[3]);
            }
        }

        br.close();
        sc.close();
    }
}
