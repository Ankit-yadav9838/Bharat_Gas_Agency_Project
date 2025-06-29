package Customers;

import gasBooking.Delivery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static int bcount = 0, ccount = 0, dcount = 0, pcount = 0;
    static String dpname;
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

            for (Delivery d : deliveries) {
                d.setLastDate(sc);
                d.getDates(sc);
                if (!skip)
                    d.validate(); // Only validate if not skipping
                d.delPersonalDetails(sc);
                d.amountCalc();
                d.verifyOtp(sc);
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
        System.out.println("Enter delivery person name:");
        try (Scanner sc = new Scanner(System.in)) {
            dpname = sc.nextLine();
            for (Delivery d : obj) {
                if ("D".equals(d.getStatus()) && d.getDelPersonName() != null && d.getDelPersonName().equals(dpname)) {
                    System.out.println("Customer: " + d.getName() + ", Address: " + d.getStreet() + ", " + d.getArea());
                }
            }
        }
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
            if ("D".equals(obj[i].getStatus())) {
                System.out.println("Invoice for " + obj[i].getName());
                System.out.println("Date: " + sdf.format(now));
                System.out.println("Amount: " + (obj[i].getAmount() != 0 ? obj[i].getAmount() : "N/A"));
                System.out
                        .println("Delivery Date: " + (obj[i].getDt_2() != null ? sdf.format(obj[i].getDt_2()) : "N/A"));
                System.out.println("-------------------");
            }
        }
    }
}