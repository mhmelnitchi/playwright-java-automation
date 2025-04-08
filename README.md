# SauceDemo Playwright Java Automation

Automated UI regression testing project for [SauceDemo Webshop](https://www.saucedemo.com/) using **Playwright + Java + TestNG + ExtentReports** with **Page Object Model** design.

---

## ✅ Tech Stack

- **Java** 17+
- **Playwright** for Java
- **TestNG** for test orchestration
- **ExtentReports** for HTML reporting
- **Maven** for build and dependency management

---

## 📁 Project Structure

```text
saucedemo-playwright
│
├── src
│   └── test
│       ├── java
│       │   ├── pages              # Page Object classes
│       │   ├── tests              # TestNG test classes
│       │   └── utils              # BaseTest, ReportManager, etc.
│
├── reports                       # ExtentReports output folder
├── pom.xml                       # Project dependencies
└── testng.xml                    # TestNG suite definition
```

---

## 🔧 Setup Instructions

1. **Install JDK 17+**
2. **Install Maven**
3. Clone this repository

---

## 🚀 Run Tests

### Full Suite (HTML report generated):
```bash
mvn clean test
```

### Run Single Test Class:
```bash
mvn -Dtest=LoginTests test
```

---

## 📄 Reports

After execution, open the HTML report:
```
reports/extent-report.html
```

It contains:
- Test case names
- Pass/fail status
- Error logs if failed

---

## 🧪 Test Coverage

- ✅ Login Tests (positive, negative, edge-case users)
- ✅ Cart Tests (add/remove/multiple items)
- ✅ Checkout Tests (full flow + validations)
- ✅ Sort Tests 
- ✅ Logout Test
- ✅ Reset App State Test

---

## 📌 Author

Mihail


