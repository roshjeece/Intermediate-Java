import java.util.ArrayList;

public class RecursiveStringPermutations {
    public static void main(String[] args) {

        String x = "ABC";

        System.out.println(permutations("", x)); // PASSING EMPTY PREFIX AND FULL STRING

    }

    public static ArrayList<String> permutations(String prefix, String remaining) {
        ArrayList<String> list = new ArrayList<>(); // CREATE ARRAYLIST TO STORE PERMUTATIONS

        // BASE CASE
        if(remaining.isEmpty()) { // IF THERE'S NOTHING LESS TO CONSIDER
            list.add(prefix); // ADD THE PREFIX WE'RE PASSING
            return list; // RETURN THE LIST
        }

        // RECURSIVE CALL
        for(int i = 0; i < remaining.length(); i++){ // CYCLE THROUGH EACH CHARACTER AS A CANDIDATE
            String newPrefix = prefix + remaining.charAt(i); // ADD PICKED CHARACTER TO PREFIX
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1); // REMAINING CHARACTERS WITH PICKED CHARACTER REMOVED
            list.addAll(permutations(newPrefix, newRemaining)); // MERGE RESULTS FROM THIS BRANCH INTO LIST
        }

        return list;
    }
}
