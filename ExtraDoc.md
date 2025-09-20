# Functional Documentation for the Test Automation Framework

```mermaid
kanban
  column2[Build: Maven]
    id3[Defines project structure]
    id3[Manages dependencies via 'pom.xml']
    id3[Runs tests via 'mvn test']

  column3[Framework: TestNG]
    id3[Testing framework for Java]
    id3[Provides annotations, assertions, test execution control, parallelism]
    id3[Manages test execution via 'testng.xml']
    id3[Integrates with Allure for reporting]

  column4[Library: Selenium]
    id3[Browser automation library]
    id3[Performs clicks, typing, navigation, element handling, etc.]
    id3[Communicates with browser drivers --- ChromeDriver]
    id3[Forms the base of Page Object Model design]

  column5[Reporting: Allure]
    id3[Reporting framework for test results]
    id3[Collects data from TestNG listeners and annotations]
    id3[Generates rich HTML reports with steps, logs, screenshots, attachments]
    id3[Provides test history, trends, and severity tagging]

```
