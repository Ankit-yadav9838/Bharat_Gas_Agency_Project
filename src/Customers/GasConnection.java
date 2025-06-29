package Customers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GasConnection extends Customer {
    private int numberOfCylinders;
    private Date lastDate = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection(String name, String street, String area, String pincode, String mobile,
            int numberOfCylinders) {
        super(name, street, area, pincode, mobile);
        if (numberOfCylinders <= 0)
            throw new IllegalArgumentException("Number of cylinders must be positive");
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

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public Date getLastDate() {
        return lastDate;
    }
}