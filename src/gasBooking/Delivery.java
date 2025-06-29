package gasBooking;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking {
    private String delPersonName;
    private int customerOtp;

    public Delivery(String name, String street, String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile, numberOfCylinders);
    }

    public void amountCalc() {
        if (getDt_2() != null && getDt_1() != null) {
            long diff = getDt_2().getTime() - getDt_1().getTime();
            if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) > 7) {
                setRefund(41.25);
                setAmount(getAmount() - getRefund());
            }
        } else {
            System.err.println("Warning: Cannot calculate amount due to missing dates.");
        }
    }

    public void verifyOtp(Scanner sc) {
        if ("B".equals(getStatus())) {
            System.out.println("Enter OTP:");
            try {
                customerOtp = sc.nextInt();
                sc.nextLine(); // Clear the newline character after nextInt
                if (customerOtp == getOtp())
                    setStatus("D");
                else
                    setStatus("C");
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid OTP. Must be a number. Setting to Canceled.");
                setStatus("C");
                sc.nextLine(); // Clear invalid input
            }
        } else {
            System.out.println("No booking to verify.");
        }
    }

    public void delPersonalDetails(Scanner sc) {
        System.out.println("Enter delivery person name:");
        delPersonName = sc.nextLine();
    }

    public String getDelPersonName() {
        return delPersonName;
    }
}