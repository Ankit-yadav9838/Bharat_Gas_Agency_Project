package gasSupplier;

public interface gasAgency {
    String AGENCY_NAME = "Bharat Gas";
    int AGENCY_CODE = 1234;
    String PHONE_NUMBER = "9838024154";
    String PIN_CODE = "201301";

    String getAgencyName();

    int getAgencyCode();

    String getPhoneNumber();

    String getPinCode();

    default void agencyDisplay() {
        System.out.println("The Agency Name is: " + getAgencyName());
        System.out.println("The Agency Code is: " + getAgencyCode());
        System.out.println("The Agency Phone Number is: " + getPhoneNumber());
        System.out.println("The Agency Pincode is: " + getPinCode());
    }
}