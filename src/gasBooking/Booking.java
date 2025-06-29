package gasBooking;

import Customers.GasConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {
    private double otp = 5678;
    private double amount = 825.0;
    private double refund = 0.0;
    private String status = "B";
    private String delMobileNo = "9838024154";
    private Date dt_1, dt_2;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Class-level field

    public Booking(String name, String street, String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile, numberOfCylinders);
    }

    public void getDates(Scanner sc) {
        System.out.println("Enter Booking Date (dd/MM/yyyy):");
        dt_1 = getValidDate(sc, "Booking Date");
        System.out.println("Enter Delivery Date (dd/MM/yyyy):");
        dt_2 = getValidDate(sc, "Delivery Date");
        if (dt_1 != null && dt_2 != null) {
            long diff = dt_2.getTime() - dt_1.getTime();
            if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) > 7)
                status = "P";
        } else {
            System.err.println("Warning: Dates not set properly. Status remains unchanged.");
        }
    }

    private Date getValidDate(Scanner sc, String field) {
        String input;
        do {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Error: No " + field + " entered. Try again.");
                continue;
            }
            try {
                return dateFormat.parse(input); // Use class-level dateFormat
            } catch (ParseException e) {
                System.err.println("Error: Invalid " + field + " format. Use dd/MM/yyyy. Try again.");
            }
        } while (true);
    }

    public void validate() {
        if (dt_1 != null && getLastDate() != null) {
            long diff = dt_1.getTime() - getLastDate().getTime();
            if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) < 30) {
                System.out.println("Booking cannot be done within 30 days of last delivery.");
                status = "C";
            }
        } else {
            System.err.println("Validation skipped: Missing date data.");
        }
    }

    public double getOtp() {
        return otp;
    }

    public double getAmount() {
        return amount;
    }

    public double getRefund() {
        return refund;
    }

    public String getStatus() {
        return status;
    }

    public String getDelMobileNo() {
        return delMobileNo;
    }

    public Date getDt_1() {
        return dt_1;
    }

    public Date getDt_2() {
        return dt_2;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setRefund(double refund) {
        this.refund = refund;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}