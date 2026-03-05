package json.problemstatements.ipl.util;

import java.io.*;

/*
 * Reads IPL CSV, applies censorship,
 * and writes a sanitized CSV file.
 */
public class IplCsvCensorAnalyzer {

    public static void main(String[] args) throws Exception {

        InputStream is = IplCsvCensorAnalyzer.class
                .getClassLoader()
                .getResourceAsStream("ipl_matches.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("censored_ipl_matches.csv")
        );

        // Write header safely
        String header = br.readLine();
        bw.write(header);
        bw.newLine();

        String line;
        while ((line = br.readLine()) != null) {

            // ✅ Skip empty or invalid lines
            if (line.trim().isEmpty()) {
                continue;
            }

            String[] data = line.split(",");

            // ✅ Ensure correct column count
            if (data.length < 7) {
                continue;
            }

            data[1] = CensorshipUtil.maskTeamName(data[1]); // team1
            data[2] = CensorshipUtil.maskTeamName(data[2]); // team2
            data[5] = CensorshipUtil.maskTeamName(data[5]); // winner
            data[6] = CensorshipUtil.redactPlayer();        // player

            bw.write(String.join(",", data));
            bw.newLine();
        }

        br.close();
        bw.close();

        System.out.println("Censored IPL CSV generated successfully");
    }
}
