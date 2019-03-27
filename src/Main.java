import java.lang.reflect.Array;
import java.util.ArrayList;

/***
 * Main class for data parser
 * @author: Zoe Chevalier
 */

public class Main {
    public static void main(String[] args) {
        //test of utils

        String data = Utils.readFileAsString("data/Unemployment.csv");
        ArrayList<DataManager> results = Utils.parseUnemploymentData(data);
        for(int i = 0; i < results.size(); i ++){
            int sum = 0;
            int countyCount = 0;
            String currentState = results.get(i).getStateName();
            while(results.get(i).getStateName() == results.get(i + 1).getStateName()){
                sum += results.get(i).getUnemploymentRate();
                i ++;
                countyCount ++;
            }
            double average = (double)(sum/countyCount);
            System.out.println(currentState + " : " + average);
        }
    }
}
