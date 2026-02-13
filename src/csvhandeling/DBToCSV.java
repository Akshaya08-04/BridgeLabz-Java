package csvhandeling;
import java.sql.*;
import java.io.*;

/*
 * Program Name : DBToCSV
 * Description  : Fetches data from database and writes to CSV.
 * Input        : MySQL database
 * Output       : db_output.csv
 */
public class DBToCSV {

    public static void main(String[] args) throws Exception {

        // Database connection
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password"
        );

        // SQL query execution
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employee");

        // Create CSV file
        BufferedWriter bw = new BufferedWriter(new FileWriter("db_output.csv"));
        bw.write("ID,Name,Department,Salary\n");

        // Write database records to CSV
        while (rs.next()) {
            bw.write(
                    rs.getInt(1) + "," +
                            rs.getString(2) + "," +
                            rs.getString(3) + "," +
                            rs.getDouble(4) + "\n"
            );
        }

        // Close all resources
        bw.close();
        con.close();

        System.out.println("Database exported to CSV successfully.");
    }
}

