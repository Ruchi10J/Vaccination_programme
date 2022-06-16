public class Booth {
    private String customerName;
    private int boothNum;


    public Booth(String customerName, int boothNum) {
        this.customerName = customerName;
        this.boothNum = boothNum;

    }

    public Booth() {   //Default

    }

    public String getCustomerName() {              //creating getters and setters
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getBoothNum() {
        return boothNum;
    }

    public void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }


}


