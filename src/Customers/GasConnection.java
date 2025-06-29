package Customers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GasConnection {
    private String name;
    private String street;
    private String area;
    private String pincode;
    private String mobile;
    private int numberOfCylinders;
    private Date lastDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection(String name, String street, String area, String pincode, String mobile,
            int numberOfCylinders) {
        this.name = name;
        this.street = street;
        this.area = area;
        this.pincode = pincode;
        this.mobile = mobile;
        this.numberOfCylinders = numberOfCylinders;
    }

    public void setLastDate(Scanner sc) {
        System.out.println("Enter the last delivery date (dd/MM/yyyy):");
        String input;
        do {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Error: No date entered. Please try again.");
                continue;
            }
            try {
                lastDate = dateFormat.parse(input);
                break;
            } catch (ParseException e) {
                System.err.println("Error: Invalid date format. Use dd/MM/yyyy. Try again.");
            }
        } while (true);
    }

    public Date getLastDate() {
        return lastDate;
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

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }
}