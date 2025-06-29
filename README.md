Bharat Gas Agency Project
Overview
The Bharat Gas Agency Project is a Java-based console application designed to manage gas cylinder bookings and deliveries for a fictional gas agency. This project simulates the workflow of a gas distribution system, allowing users to input delivery details, validate consumer identities, and generate reports and invoices. It serves as an educational tool for learning object-oriented programming (OOP) concepts, file handling, and basic input validation in Java.

Created On: June 29, 2025
Developed By: [Your Name or Team Name]
Language: Java
Environment: Windows 11, Git Bash in VS Code

Features

Dynamic Delivery Management: Handle 1 to 5 deliveries per session based on user input.
OTP Verification: Generates a random 4-digit OTP for each booking, simulating SMS delivery to the consumer's mobile number.
Consumer Validation: Allows delivery personnel to validate the consumer using a registered mobile number.
30-Day Validation: Prevents bookings within 30 days of the last delivery date unless skipped for testing.
Report Generation: Provides monthly cylinder delivery counts, late delivery statistics, and a list of single-cylinder holders.
Invoice Generation: Creates invoices for successfully delivered orders with details like amount and delivery date.

Prerequisites

Java Development Kit (JDK): Version 8 or higher (e.g., JDK 17).
Integrated Development Environment (IDE): Recommended - Visual Studio Code with Java Extension Pack and Git Bash.
Git: For version control and repository management.

Installation

Clone the Repository
git clone https://github.com/your-username/bharat-gas-agency-project.git
cd bharat-gas-agency-project

(Replace your-username with your GitHub username and update the repository URL.)

Compile the Project

Open Git Bash in the src directory:cd src
javac -d . Customers/_.java gasBooking/_.java gasSupplier/\*.java

Run the Application
java Customers.Main

Usage

Start the Program

Run the compiled Main.java file to launch the application.

Input Options

Skip 30-Day Validation: Enter yes or no to bypass the 30-day rule for testing.
Number of Deliveries: Specify 1 to 5 deliveries to process.
Delivery Details: For each delivery, enter:
Last delivery date (dd/MM/yyyy)
Booking date (dd/MM/yyyy)
Delivery date (dd/MM/yyyy)

If valid (outside 30-day window), the program generates an OTP and simulates sending it to the consumer’s mobile.

OTP and Validation

Copy the displayed OTP, send it to yourself via a messaging app, and paste it when prompted.
The delivery person enters the consumer’s mobile number to validate the recipient.

Output

View reports (e.g., cylinder counts per month, late deliveries) and invoices for successful deliveries.

Project Structure

Customers/: Contains Main.java (entry point), GasConnection.java (base class), and Customer.java (interface).
gasBooking/: Includes Booking.java (handles booking logic) and Delivery.java (manages delivery verification).
gasSupplier/: Contains gasAgency.java (placeholder for supplier logic).

Example Workflow

---

                    Bharat Gas Agency

---

Skip 30-day validation for testing? (yes/no):
[Input: no]
How many deliveries to process? (1-5):
[Input: 2]
Please enter the 1st delivery details...
Enter the last delivery date (dd/MM/yyyy):
[Input: 29/05/2025]
Enter Booking Date (dd/MM/yyyy):
[Input: 15/06/2025]
Enter Delivery Date (dd/MM/yyyy):
[Input: 20/06/2025]
Booking cannot be done within 30 days of last delivery.
Please enter the 2nd delivery details...
Enter the last delivery date (dd/MM/yyyy):
[Input: 28/05/2025]
Enter Booking Date (dd/MM/yyyy):
[Input: 29/06/2025]
Enter Delivery Date (dd/MM/yyyy):
[Input: 06/07/2025]
Generated OTP for this booking: 4832
Simulating SMS to your mobile: 9990809987. Please copy the OTP above, send it to yourself via a messaging app, and paste it when prompted.
Enter delivery person name for this delivery:
[Input: John Doe]
Enter OTP:
[Input: 4832]
Delivery Person: Enter consumer's mobile number to validate:
[Input: 9990809987]
Consumer validated. Delivery confirmed.
Month: June, Cylinders Delivered: 1
Single Cylinder Holders:
Customer: Parvati, Mobile: 9990809987
...
Report - Booked: 0, Delivered: 1, Cancelled: 1, Pending: 0
Invoice for Parvati (Delivered by: John Doe)
Date: 29/06/2025
Amount: 825.0
Delivery Date: 06/07/2025

---

Program completed.

Contributing

Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make changes and commit (git commit -m "Add new feature").
Push to the branch (git push origin feature-branch).
Open a Pull Request.

License
This project is licensed under the MIT License - see the LICENSE file for details (add a LICENSE file if not present).
Acknowledgments

Inspired by gas agency management systems.
Thanks to the Java community for robust libraries and documentation.
