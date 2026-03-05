package json.problemstatements.ipl.model;

import java.util.Map;

/*
 * IPL Match POJO
 * Must match JSON structure exactly
 */
public class IplMatch {

    public int match_id;
    public String team1;
    public String team2;

    /*
     * Key   -> Team Name
     * Value -> Score
     */
    public Map<String, Integer> score;

    public String winner;
    public String player_of_match;
}