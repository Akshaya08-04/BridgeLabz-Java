package csvhandeling;
import java.io.*;

/*
 * Program Name : UpdateCSV
 * Description  : Increases IT department salary by 10%.
 */
public class UpdateCSV {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("updated.csv"));

        String line;

        // Copy header
        bw.write(br.readLine() + "\n");

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data[2].equalsIgnoreCase("IT")) {
                double salary = Double.parseDouble(data[3]);
                salary *= 1.10;
                data[3] = String.valueOf(salary);
            }

            bw.write(String.join(",", data) + "\n");
        }

        br.close();
        bw.close();
    }
}

