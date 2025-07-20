# 🇮🇳 Bharat Gas Agency Project 🔥

## 📌 Overview

The **Bharat Gas Agency Project** is a Java-based console application simulating a real-world gas cylinder booking and delivery system. It was developed as an academic project to demonstrate:

- ✅ Java OOP principles
- 📁 File handling
- 🔐 OTP validation
- 📊 Report & Invoice generation

## 📚 Table of Contents

- [🚀 Features](#-features)
- [🛠️ Tech Stack](#-tech-stack)
- [📁 Project Structure](#-project-structure)
- [📦 Installation](#-installation)
- [▶️ Usage](#️usage)
- [📟 Sample Workflow](#sample-workflow)
- [📬 Contact](#contact)

## 🚀 Features

- 🔄 **Dynamic Booking**: Handle 1–5 deliveries per session
- 🔐 **OTP System**: 4-digit OTP verification for secured delivery
- 📞 **Mobile Validation**: Consumer is validated by registered number
- ⛔ **30-Day Rule**: Refill not allowed within 30 days (test bypass supported)
- 📊 **Reports**: Cylinder count, late deliveries, and pending bookings
- 🧾 **Invoice Generator**: Delivery bill with name, amount, and date

## 🛠️ Tech Stack

- 🖥️ **Language**: Java (JDK 8 or later)
- 💻 **IDE**: Visual Studio Code + Git Bash
- 🗂️ **Version Control**: Git + GitHub
- 🧪 **Tested On**: Windows 11

## 📁 Project Structure

```
bharat-gas-agency-project/
│
├── Customers/
│   ├── Main.java              // Entry point
│   ├── GasConnection.java     // Base class
│   └── Customer.java          // Interface
│
├── gasBooking/
│   ├── Booking.java           // Booking logic
│   └── Delivery.java          // Delivery + OTP logic
│
└── gasSupplier/
    └── gasAgency.java         // Placeholder for supplier logic
```

## 📦 Installation

```bash
# Step 1: Clone the Repository
git clone https://github.com/your-username/bharat-gas-agency-project.git
cd bharat-gas-agency-project

# Step 2: Compile the Java Files
cd src
javac -d . Customers/*.java gasBooking/*.java gasSupplier/*.java

# Step 3: Run the Application
java Customers.Main
```

## ▶️ [Usage](#️usage)

**Booking Flow:**

- Enter whether to skip 30-day rule (for testing)
- Choose number of deliveries to process
- For each delivery, input:
  - Last delivery date
  - Booking date
  - Delivery date
- If valid, OTP is generated and must be matched
- Consumer is validated by mobile number

## 📟 [Sample Workflow](#sample-workflow)

```
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

📊 Month: June, Cylinders Delivered: 1
📞 Single Cylinder Holders: Parvati (9990809987)

🧾 Invoice:
Customer: Parvati
Delivered By: John Doe
Amount: ₹825.0
Booking Date: 29/06/2025
Delivery Date: 06/07/2025
```

## 🤝 Contribution

Want to improve or add features?

```bash
# 1. Fork the repo
# 2. Create your feature branch
git checkout -b feature-xyz

# 3. Commit your changes
git commit -m "Add feature: XYZ"

# 4. Push to GitHub
git push origin feature-xyz
```

## 📬 [Contact](#contact)

**Ankit Yadav**  
📧 a.k.chaudhary9838@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/ankit-yadav-063216265)

💡 _“Build to learn, not just to deploy.” — Ankit Yadav_
