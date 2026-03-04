package json.problemstatements.ipl.util;


/*
 * Applies censorship rules
 */
public class CensorshipUtil {

    /*
     * Mask team name
     * Example: Mumbai Indians → Mumbai ***
     */
    public static String maskTeamName(String teamName) {
        return teamName.split(" ")[0] + " ***";
    }

    /*
     * Redact player of the match
     */
    public static String redactPlayer() {
        return "REDACTED";
    }
}
