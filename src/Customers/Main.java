package Customers;

import gasBooking.Delivery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static int bcount = 0, ccount = 0, dcount = 0, pcount = 0;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.println("****************************************************************");
        System.out.println("                      Bharat Gas Agency                         ");
        System.out.println("****************************************************************");
        Delivery[] deliveries = new Delivery[5];
        deliveries[0] = new Delivery("Parvati", "4th Ave", "Alpha-2", "201308", "9990809987", 1);
        deliveries[1] = new Delivery("Hanuman", "4th Ave", "Gamma-2", "201305", "9838022564", 2);
        deliveries[2] = new Delivery("Krishna", "4th Ave", "Alpha-2", "201306", "9825461455", 1);
        deliveries[3] = new Delivery("Ganga", "4th Ave", "Alpha-2", "201307", "9835648523", 2);
        deliveries[4] = new Delivery("Nandi", "4th Ave", "Pi-2", "201309", "7068801272", 1);

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Skip 30-day validation for testing? (yes/no):");
            String skipValidation = sc.nextLine().trim().toLowerCase();
            boolean skip = skipValidation.equals("yes");

            System.out.println("How many deliveries to process? (1-5):");
            int numDeliveries = 0;
            try {
                numDeliveries = Integer.parseInt(sc.nextLine().trim());
                if (numDeliveries < 1 || numDeliveries > 5) {
                    System.err.println("Error: Number must be between 1 and 5. Defaulting to 1.");
                    numDeliveries = 1;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid number. Defaulting to 1.");
                numDeliveries = 1;
            }

            for (int i = 0; i < numDeliveries && i < deliveries.length; i++) {
                System.out.println("Please enter the " + getOrdinal(i + 1) + " delivery details...");
                deliveries[i].setLastDate(sc);
                deliveries[i].getDates(sc);
                if (!skip && deliveries[i].isValid()) { // Only process if not skipped and valid
                    deliveries[i].validate();
                    deliveries[i].delPersonalDetails(sc);
                    deliveries[i].amountCalc();
                    deliveries[i].verifyOtp(sc);
                }
            }
            cylinderCount(deliveries);
            checkLateDel(deliveries);
            numOfSingleCylinders(deliveries);
            deliveryDetails(deliveries);
            printReport(deliveries);
            printInvoice(deliveries);
        } finally {
            sc.close();
        }

        System.out.println("Program completed.");
    }

    // Helper method to get ordinal numbers (1st, 2nd, 3rd, etc.)
    private static String getOrdinal(int number) {
        if (number >= 11 && number <= 13) {
            return number + "th";
        }
        switch (number % 10) {
            case 1:
                return number + "st";
            case 2:
                return number + "nd";
            case 3:
                return number + "rd";
            default:
                return number + "th";
        }
    }

    public static void cylinderCount(Delivery[] obj) {
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December" };
        java.util.HashMap<String, Integer> count = new java.util.HashMap<>();
        for (Delivery d : obj) {
            if ("D".equals(d.getStatus()) && d.getDt_2() != null) {
                count.merge(months[d.getDt_2().getMonth()], d.getNumberOfCylinders(), Integer::sum);
            }
        }
        for (String month : months) {
            if (count.containsKey(month)) {
                System.out.println("Month: " + month + ", Cylinders Delivered: " + count.get(month));
            }
        }
    }

    public static void checkLateDel(Delivery[] obj) {
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December" };
        int[] late = new int[12];
        for (Delivery d : obj) {
            if ("D".equals(d.getStatus()) && d.getDt_2() != null && d.getAmount() == 783.75) {
                late[d.getDt_2().getMonth()]++;
            }
        }
        for (int i = 0; i < 12; i++) {
            if (late[i] > 0) {
                System.out.println("Late deliveries in " + months[i] + ": " + late[i]);
            }
        }
    }

    public static void numOfSingleCylinders(Delivery[] obj) {
        System.out.println("Single Cylinder Holders:");
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].getNumberOfCylinders() == 1) {
                System.out.println("Customer: " + obj[i].getName() + ", Mobile: " + obj[i].getMobile());
            }
        }
    }

    public static void deliveryDetails(Delivery[] obj) {
        // No need for dpname prompt; use per-delivery delPersonName
    }

    public static void printReport(Delivery[] obj) {
        for (Delivery d : obj) {
            switch (d.getStatus()) {
                case "D":
                    dcount++;
                    break;
                case "B":
                    bcount++;
                    break;
                case "C":
                    ccount++;
                    break;
                case "P":
                    pcount++;
                    break;
            }
        }
        System.out.println("Report - Booked: " + bcount + ", Delivered: " + dcount + ", Cancelled: " + ccount
                + ", Pending: " + pcount);
    }

    public static void printInvoice(Delivery[] obj) {
        Date now = new Date();
        for (int i = 0; i < obj.length; i++) {
            if ("D".equals(obj[i].getStatus()) && obj[i].getDelPersonName() != null) {
                System.out.println(
                        "Invoice for " + obj[i].getName() + " (Delivered by: " + obj[i].getDelPersonName() + ")");
                System.out.println("Date: " + sdf.format(now));
                System.out.println("Amount: " + (obj[i].getAmount() != 0 ? obj[i].getAmount() : "N/A"));
                System.out
                        .println("Delivery Date: " + (obj[i].getDt_2() != null ? sdf.format(obj[i].getDt_2()) : "N/A"));
                System.out.println("-------------------");
            }
        }
    }
}