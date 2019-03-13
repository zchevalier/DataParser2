public class County {

    private String name;
    private int fips;
    private ElectionResult electionResult;
    private EducationResult educationResult;
    private EmploymentResult employmentResult;

    public County(String name, int fips, ElectionResult vote2016, EducationResult educ2016, EmploymentResult employ2016) {
        this.name = name;
        this.fips = fips;
        this.electionResult = vote2016;
        this.educationResult = educ2016;
        this.employmentResult = employ2016;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFips() {
        return fips;
    }

    public void setFips(int fips) {
        this.fips = fips;
    }

    public ElectionResult getElectionResult() {
        return electionResult;
    }

    public void setElectionResult(ElectionResult electionResult) {
        this.electionResult = electionResult;
    }

    public EducationResult getEduc2016() {
        return educationResult;
    }

    public void setEduc2016(EducationResult educ2016) {
        this.educationResult = educ2016;
    }

    public EmploymentResult getEmploymentResult() {
        return employmentResult;
    }

    public void setEmploymentResult(EmploymentResult employmentResult) {
        this.employmentResult = employmentResult;
    }


}
