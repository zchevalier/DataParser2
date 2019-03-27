import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
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

   public static ArrayList<DataManager> parseUnemploymentData(String data){

        ArrayList<DataManager> output = new ArrayList<>();
        String[] rows = data.split("\n");

        for(int i = 10; i < rows.length; i ++){

            String[] characters = cleanRow(rows[i]);

            for(int j = 0; j < characters.length; j ++){
                characters[j].trim();
            }

            if(characters[3].contains("County")){
                String stateName = characters[2];
                String countyName = characters[3];
                double unemploymentRate2016 = Double.parseDouble(characters[46]);

                DataManager result = new DataManager(stateName, countyName, unemploymentRate2016);
                output.add(result);
            }
            System.out.println(output);
        } return output;
   }

    private static String removeCommas(String data, int firstIndex) {

        int secondIndex = data.indexOf("\"", firstIndex + 1);

        String middle = data.substring(firstIndex + 1, secondIndex);
        String first = data.substring(0, firstIndex);
        String last = data.substring(secondIndex + 1);

        int indexOfComma = middle.indexOf(",");

        while (indexOfComma != -1) {
            middle = middle.substring(0, indexOfComma) + middle.substring(indexOfComma + 1);
            indexOfComma = middle.indexOf(",");
        }

        return (first + middle + last);
    }


    private static String[] cleanRow (String data) {
        String [] characters;

        int firstIndex = data.indexOf("\"");

        if (firstIndex != -1){
            while (firstIndex != -1) {
                data = removeCommas(data, firstIndex);
                firstIndex = data.indexOf("\"");
            }
            characters = data.split(",");

        }else {
            characters = data.split(",");
        }
        return characters;
    }



}
