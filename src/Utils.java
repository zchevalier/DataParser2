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
            String [] a = rows[i].split(",");
            ElectionResults result = new ElectionResults(Integer.parseInt(a[0]), (double)Integer.parseInt(a[1]), (double)Integer.parseInt(a[2]),
                    Integer.parseInt(a[3]), (double)Integer.parseInt(a[4]), (double)Integer.parseInt(a[5]), a[6],
                    (double)Integer.parseInt(a[7]), a[8], Integer.parseInt(a[9]));
            output.add(result);
        } return output;
    }
}
