/***
 * Main class for data parser
 * @author: Zoe Chevalier
 */

public class Main {
    public static void main(String[] args) {
        //test of utils

        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        System.out.println(data);
    }
}
