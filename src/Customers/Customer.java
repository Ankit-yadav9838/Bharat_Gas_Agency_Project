package Customers;

import gasSupplier.gasAgency;

public class Customer implements gasAgency {
    private String name;
    private String street;
    private String area;
    private String pincode;
    private String mobile;

    public Customer(String name, String street, String area, String pincode, String mobile) {
        this.name = name;
        this.street = street;
        this.area = area;
        this.pincode = pincode;
        this.mobile = mobile;
    }

    @Override
    public String getAgencyName() {
        return AGENCY_NAME;
    }

    @Override
    public int getAgencyCode() {
        return AGENCY_CODE;
    }

    @Override
    public String getPhoneNumber() {
        return PHONE_NUMBER;
    }

    @Override
    public String getPinCode() {
        return PIN_CODE;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getArea() {
        return area;
    }

    public String getPincode() {
        return pincode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}