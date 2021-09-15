package Service.operatorUserInput;


public class MongoDTO {

    private String state;
    private String city;
    private String school;
    private String billerId;

    public MongoDTO(String state, String city, String school, String billerId) {
        this.state = state;
        this.city = city;
        this.school = school;
        this.billerId = billerId;
    }

    public MongoDTO(){}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBillerId() {
        return billerId;
    }

    public void setBillerId(String billerId) {
        this.billerId = billerId;
    }

    @Override
    public String toString() {
        return "MongoDTO{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", school='" + school + '\'' +
                ", billerId='" + billerId + '\'' +
                '}';
    }
}

