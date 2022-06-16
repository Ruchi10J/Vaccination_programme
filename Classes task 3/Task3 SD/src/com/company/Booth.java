package com.company;

public class Booth {
    private String customerName;
    private int boothNum;
    private String Surname;
    private int age;
    private String city;
    private int NIC;
    private String type;

    public Booth(String customerName,int boothNum,String Surname,int age,String city,int NIC,String type) {
        this.customerName = customerName;
        this.boothNum = boothNum;
        this.Surname = Surname;
        this.age = age;
        this.city = city;
        this.NIC = NIC;
        this.type = type;
    }


    public Booth() {   //Default

    }

    public String getCustomerName() {                       //Creating getters and setters
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




    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNIC() {
        return NIC;
    }

    public void setNIC(int NIC) {
        this.NIC = NIC;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}



