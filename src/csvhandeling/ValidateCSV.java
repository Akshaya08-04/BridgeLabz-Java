package csvhandeling;
import java.io.*;

/*
 * Program Name : ValidateCSV
 * Description  : Validates email and phone number.
 */
public class ValidateCSV {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String phoneRegex = "\\d{10}";

        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (!data[4].matches(emailRegex) ||
                    !data[5].matches(phoneRegex)) {

                System.out.println("Invalid row: " + line);
            }
        }
    }
}

