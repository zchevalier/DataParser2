import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResults> parse2016PresidentialResults(String data){
        ArrayList<ElectionResults> output = new ArrayList<>();
        String [] rows = data.split("\n");

        for(int i = 1; i < rows.length; i ++){
                String cleanedRow = clean(rows[i]);

                String[] a = rows[i].split(",");
                if (a.length == 11) {
                    ElectionResults result = new ElectionResults(Integer.parseInt(a[0]), Double.parseDouble(a[1]), Double.parseDouble(a[2]),
                            Double.parseDouble(a[3]), Double.parseDouble(a[4]), Integer.parseInt(a[5]), Double.parseDouble(a[6]),
                            a[7], a[8], Integer.parseInt(a[9]));
                    output.add(result);
                } else {
                    System.out.println("Error at row " + i);
                }
            }
        return output;
    }

   private static String cleanLine(String row){
        int firstQuote = row.indexOf("\"");
        int secondQuote = row.indexOf("\"", firstQuote + 1);

        while(firstQuote != -1 && secondQuote != -1){
            row = cleanSection(row, firstQuote, secondQuote);
            firstQuote = row.indexOf("\"");
            secondQuote = row.indexOf("\"", firstQuote + 1);
        }
        return row;
   }

    private static String cleanSection(String row, int firstQuote, int secondQuote) {
        String previous = row.substring(0, firstQuote);
        String next = row.substring(secondQuote + 1);
        String uncleaned = row.substring(firstQuote + 1, secondQuote);

        return previous + clean(uncleaned) + next;
    }

    private static String clean(String uncleaned) {
        uncleaned = uncleaned.replaceAll(",", "").trim();
        uncleaned = uncleaned.replaceAll("%", "").trim();
        return uncleaned;
    }

}
