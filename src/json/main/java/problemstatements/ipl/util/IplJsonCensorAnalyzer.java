package json.problemstatements.ipl.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.problemstatements.ipl.model.IplMatch;
import json.problemstatements.ipl.util.CensorshipUtil;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/*
 * Reads IPL JSON, censors team names (including score keys),
 * and writes censored JSON
 */
public class IplJsonCensorAnalyzer {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        InputStream is = IplJsonCensorAnalyzer.class
                .getClassLoader()
                .getResourceAsStream("ipl_matches.json");

        IplMatch[] matches = mapper.readValue(is, IplMatch[].class);

        for (IplMatch match : matches) {

            match.team1 = CensorshipUtil.maskTeamName(match.team1);
            match.team2 = CensorshipUtil.maskTeamName(match.team2);
            match.winner = CensorshipUtil.maskTeamName(match.winner);
            match.player_of_match = CensorshipUtil.redactPlayer();

            // Censor score keys
            Map<String, Integer> censoredScore = new HashMap<>();
            for (Map.Entry<String, Integer> entry : match.score.entrySet()) {
                censoredScore.put(
                        CensorshipUtil.maskTeamName(entry.getKey()),
                        entry.getValue()
                );
            }
            match.score = censoredScore;
        }

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("censored_ipl_matches.json"), matches);

        System.out.println("Censored IPL JSON generated successfully");
    }
}