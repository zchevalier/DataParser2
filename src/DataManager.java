public class DataManager {

    private String stateName;
    private String countyName;
    private double unemploymentRate;

    public DataManager(String stateName, String county, double unemploymentRate) {
        this.countyName = county;
        this.unemploymentRate = unemploymentRate;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public void setUnemploymentRate(double unemploymentRate) {
        this.unemploymentRate = unemploymentRate;
    }

    public String getCountyName() {
        return countyName;
    }

    public double getUnemploymentRate() {
        return unemploymentRate;
    }
}
