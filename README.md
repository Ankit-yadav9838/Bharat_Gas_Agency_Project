
markdown
Copy
Edit
# 🇮🇳 Bharat Gas Agency Project 🔥

A **Java-based console application** that simulates a gas cylinder booking and delivery system for a fictional Bharat Gas Agency. This educational project showcases real-world utility with a focus on **OOP concepts**, **file handling**, **OTP verification**, and **report generation**.

---

## 📌 Project Overview

The **Bharat Gas Agency Project** helps in managing gas bookings, verifying customers, validating deliveries, and generating invoices—all from the command line.

This project was built to:
- Simulate the operational workflow of a gas agency.
- Learn core Java programming (OOP, date handling, file I/O).
- Understand basic software design practices for utility-based apps.

---

## 🧑‍💻 Developed By

**Ankit Yadav**  
🎓 B.Tech Final Year, Electronics  
🗓️ Created On: June 29, 2025  
💻 Environment: Java (JDK 8+), Git Bash, VS Code on Windows 11

---

## 🚀 Features

✅ **Dynamic Booking Management** – Handle up to 5 bookings per session  
🔐 **OTP-Based Delivery Validation** – Secure delivery through 4-digit OTPs  
📅 **30-Day Refill Rule** – Prevent refills within 30 days (can be skipped for testing)  
📊 **Reports** – Monthly delivery stats, late deliveries, and single-cylinder holder list  
🧾 **Invoice Generator** – Auto-generate delivery invoices for completed bookings  
📞 **Consumer Validation** – Mobile number-based verification  

---

## 🛠️ Tech Stack

- **Language**: Java (JDK 8 or higher)
- **IDE**: VS Code with Java Extensions
- **Version Control**: Git
- **Terminal**: Git Bash or Command Prompt

---

## 📁 Project Structure

bharat-gas-agency-project/
│
├── Customers/
│ ├── Main.java // Entry point
│ ├── GasConnection.java // Base class
│ └── Customer.java // Interface
│
├── gasBooking/
│ ├── Booking.java // Handles booking logic
│ └── Delivery.java // Manages OTP + delivery verification
│
└── gasSupplier/
└── gasAgency.java // Supplier placeholder

yaml
Copy
Edit

---

## ⚙️ How to Run the Project

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/bharat-gas-agency-project.git
cd bharat-gas-agency-project
Replace your-username with your GitHub handle.

2. Compile the Code
bash
Copy
Edit
cd src
javac -d . Customers/*.java gasBooking/*.java gasSupplier/*.java
3. Run the Application
bash
Copy
Edit
java Customers.Main
▶️ Sample Workflow
text
Copy
Edit
****************************************************************
                    Bharat Gas Agency
****************************************************************

Skip 30-day validation for testing? (yes/no): no
How many deliveries to process? (1-5): 2

Enter the 1st delivery details:
Last Delivery Date: 29/05/2025
Booking Date: 15/06/2025
Delivery Date: 20/06/2025
=> Booking not allowed within 30 days!

Enter the 2nd delivery details:
Last Delivery Date: 28/05/2025
Booking Date: 29/06/2025
Delivery Date: 06/07/2025
Generated OTP: 4832
Simulated SMS to: 9990809987

Delivery Person Name: John Doe
Enter OTP: 4832
Enter consumer's mobile number: 9990809987

✅ Consumer validated. Delivery confirmed.

📦 Delivery Stats:
Month: June | Delivered: 1
Single Cylinder Holders: Parvati (9990809987)

🧾 Invoice:
Customer: Parvati
Delivered By: John Doe
Amount: ₹825.0
Booking Date: 29/06/2025
Delivery Date: 06/07/2025

-------------------------
Program completed.
📊 Sample Output Reports
Total Deliveries: 1

Booked: 0

Cancelled: 1

Delivered: 1

Pending: 0

Single Cylinder Holders: Parvati (9990809987)

📈 Learning Highlights
Java class design (interfaces, inheritance)

File I/O (reading/writing delivery logs)

Date manipulation using SimpleDateFormat

OTP simulation and basic security flow

CLI interactivity with Scanner

🤝 Contributing
Want to contribute?

bash
Copy
Edit
# Fork and clone the repository
git clone https://github.com/your-username/bharat-gas-agency-project.git

# Create a feature branch
git checkout -b feature-branch

# Make your changes, then commit
git commit -m "Add feature: XYZ"

# Push and open a Pull Request
git push origin feature-branch
🪪 License
This project is licensed under the MIT License.
See the LICENSE file for details.

🙌 Acknowledgments
Inspired by real-life gas distribution systems.

Thanks to the Java community for tutorials, guides, and support.

📬 Connect with Me
📧 ankit.yourmail@example.com
🔗 LinkedIn
🌐 Portfolio (optional)

“Build projects not to impress, but to express what you’ve learned.” – Ankit Yadav

markdown
Copy
Edit

---

### ✅ What You Should Do Next

1. **Replace** all placeholders:
   - `your-username`
   - `ankit.yourmail@example.com`
   - LinkedIn or Portfolio links

2. **Add a LICENSE file** (MIT license recommended — I can generate it if you want).

3. **Push to GitHub** and enjoy a polished project profile!

Let me know if you want a banner, logo, or license file too.







