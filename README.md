# 🧪 Test Automation Framework

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Build-red.svg)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/TestNG-Testing-green.svg)](https://testng.org/)
[![Selenium](https://img.shields.io/badge/Selenium-Automation-brightgreen.svg)](https://www.selenium.dev/)
[![CI](https://github.com/MahmoudFawzyAOE2/mft1998-portfolio-TestAutomation/actions/workflows/Run%20Tests.yml/badge.svg)](https://github.com/MahmoudFawzyAOE2/mft1998-portfolio-TestAutomation/actions)

A **UI test automation framework** built with **Java, TestNG, and Selenium**.  
This project is designed for testing core functionalities of My portfolio website, with support for CI/CD pipelines via **GitHub Actions**.

---

## 📂 Project Structure - `main` branch

```
├── .github/workflows/       # GitHub Actions CI/CD workflows
├── src/
│   ├── main/java/           # Framework source code
│   │   ├── drivers/         # WebDriver setup and management
│   │   ├── listeners/       # TestNG custom listeners
│   │   ├── pages/           # Page Object Model (POM) classes
│   │   │   └── components/  # Reusable UI components
│   │   ├── testData/        # Centralized test data (URLs, constants)
│   │   └── utils/           # Utilities (Waits, Actions, Assertions, etc.)
│   └── test/java/           # Test classes
│       └── tests/ui/        # UI tests
├── test-output/             # Default TestNG reports (auto-generated)
├── pom.xml                  # Maven dependencies & build config
└── testng.xml               # TestNG suite configuration
```

---

## 🚀 Features

- **UI Automation** using **Selenium + TestNG**
- **Page Object Model (POM)** for clean and reusable test code
- **Utilities layer** for common actions (waits, assertions, element interactions, etc.)
- **TestNG Listeners** for reporting and preserving execution Logs 
- **Allure Reports** and its deployment via Github Pages
- **GitHub Actions Integration** for CI/CD pipelines 
- **Separation of Concerns**:  
  - `src/main/java` → Framework code  
  - `src/test/java` → Test cases

---

## ⚙️ Setup & Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/MahmoudFawzyAOE2/mft1998-portfolio-TestAutomation.git
   cd **mft1998-portfolio-TestAutomation**
   ```

2. **Install Dependencies**
   Ensure you have **Maven** installed. Then run:
   ```bash
   mvn clean install
   ```

3. **Run Tests**
   - Run all tests:
     ```bash
     mvn clean test
     ```

---

## 📊 Reports

- **Allure Reports** → `test-output/`  
  Allure HTML Reports are deployed via Github Pages to [Reports Website](https://mahmoudfawzyaoe2.github.io/mft1998-portfolio-TestAutomation/)

---

## 🖥️ CI/CD Integration

This project is configured with **GitHub Actions** (`.github/workflows/`):
- `Run Tests.yml` → Executes the test suite on push

### 🔄 Workflow Between Repositories

The CI/CD process connects **three repositories**:

1. **[Website Repo](https://github.com/MahmoudFawzyAOE2/mft1998-portfolio)**
    - Stores portfolio website code.
    - Fires the **`run-test` trigger** whenever changes are built and deployed to [Portfolio Website](https://mahmoudfawzyaoe2.github.io/mft1998-portfolio).

2. **Test Repo** (This Repo)
    - Contains test automation code .
    - Executes test cases when triggered by:
        - Manual workflow dispatch, or
        - Tests edits (push to this Repo), or
        - Trigger event from Website Repo.
    - Generates Allure Reports on a secondary branch `gh-pages` .
    - Deploys the HTML Report to [Reports Website](https://mahmoudfawzyaoe2.github.io/mft1998-portfolio-TestAutomation/)
    - Sends an Email which notifies about the done tests and includes a link to the reporting website
    - Keeps history of the previous runs to track excution history

### 📊 Repository Interaction Graph via CI/CD workflows

```mermaid
graph TD
    A[/📂 Website Repo\] -- 1) Deploy --> F(🌐 Portfolio Website)
    A -- 2) run-test trigger --> B[/📂 Test Repo - main Branch\]
    E -- Test Edits --> B
    E((👤SW Tester)) -- Manual Dispatch --> B
    B -- 3) Commit Allure Reports --> C[/📂 Test Repo - gh-Pages Branch\]
    C -- 4) Deploy Report --> D(🌐 Report Website)
    C -- 5) Email --> G((👤 Stakeholders))   
```

## 🔧 Tech Stack

- **Language:** Java 17+
- **Build Tool:** Maven
- **Test Framework:** TestNG
- **UI Automation:** Selenium WebDriver
- **Reporting:** Allure Reports
- **CI/CD:** GitHub Actions

---

## 📌 Next Improvements

- [ ] Review The framework to ensure best practices are being followed
- [ ] Enhance The CI/CD Triggers to exclude non-code related changes
- [ ] Impoove Test data management
- [ ] Add more custom listeners for better events logging
- [ ] Add Utils Documentation
- [ ] Increase Test coverage by adding other pages
- [ ] Add parallel test execution  
- [ ] Add Screenshot for better reporting
- [ ] Add API Tests using RestAssured
- [ ] Improve test categorization (smoke, regression, API, UI)  

---

## 👤 Author

**Mahmoud Fawzy**  
🔗 [GitHub](https://github.com/MahmoudFawzyAOE2) | [LinkedIn](https://linkedin.com/in/mft1998)

---
