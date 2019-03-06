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
            checkForExceptions(rows[i]);
            String [] a = rows[i].split(",");
            if(a.length == 11) {
                ElectionResults result = new ElectionResults(Integer.parseInt(a[0]), Double.parseDouble(a[1]), Double.parseDouble(a[2]),
                        Double.parseDouble(a[3]), Double.parseDouble(a[4]), Integer.parseInt(a[5]), Double.parseDouble(a[6]),
                        a[7], a[8], Integer.parseInt(a[9]));
                output.add(result);
            } else {
                System.out.println("Error at row " + i);
            }
        } return output;
    }

    private static void checkForExceptions(String str) {
        ArrayList<Integer> exceptions = new ArrayList<>();

        boolean checkForSecondException = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.substring(i, i + 1).equals("\'") && checkForSecondException == false) {
                str = str.replace(str.substring(i, i + 1), "");
                str.replace(str.substring(i - 4, i - 3), "");
            } else if (str.substring(i, i + 1).equals("\'")) {
                str = str.replace(str.substring(i, i + 1), "");
            } else if (str.substring(i, i + 1).equals("%")) {
                str.replace(str.substring(i, i + 1), "");
            }
        }
    }
}
