# 🚀 Enterprise Selenium Hybrid Framework

An enterprise-grade UI Automation Framework built using **Java, Selenium 4, TestNG, Maven, Page Object Model (POM), ThreadLocal Design Pattern, Extent Reports, Apache POI, Jackson, Log4j2, GitHub Actions, and Jenkins**.

This framework follows industry best practices with reusable utilities, scalable architecture, maintainable code structure, data-driven testing, cross-browser execution, and CI/CD integration. It is designed to demonstrate how a production-ready Selenium automation framework is structured and implemented.

---

# 📖 Table of Contents

- Overview
- Technology Stack
- Framework Features
- Project Structure
- Framework Architecture
- Design Patterns Used
- Utilities
- Data-Driven Testing
- Reporting
- Logging
- Assertions
- Retry Mechanism
- Parallel Execution
- Cross Browser Execution
- Environment Configuration
- Jenkins Pipeline
- GitHub Actions
- Project Execution
- Reports
- Future Enhancements
- Author

---

# 📌 Overview

The Enterprise Selenium Hybrid Framework is designed to automate web applications using modern Selenium automation practices.

The framework provides:

- Scalable Architecture
- Reusable Components
- Thread-safe WebDriver
- Enterprise-level Utilities
- Data-Driven Testing
- Cross Browser Support
- Headless Execution
- Rich HTML Reporting
- CI/CD Integration
- Easy Maintenance

---

# 🛠 Technology Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Selenium WebDriver | 4.x |
| TestNG | Latest |
| Maven | Latest |
| Apache POI | Latest |
| Jackson | Latest |
| Log4j2 | Latest |
| Extent Reports | Latest |
| WebDriverManager | Latest |
| Git | Latest |
| GitHub | Latest |
| Jenkins | Latest |

---

# ✨ Framework Features

- Selenium 4 Automation
- Java 21
- TestNG Framework
- Maven Build Tool
- Page Object Model (POM)
- ThreadLocal WebDriver
- Driver Factory Pattern
- Cross Browser Execution
- Parallel Execution Support
- Retry Analyzer
- Hard & Soft Assertions
- Explicit Wait Utilities
- Screenshot Capture
- Extent HTML Reports
- Log4j2 Logging
- Excel Data-Driven Testing
- JSON Data-Driven Testing
- Environment-Based Execution
- Headless Execution
- Reusable Utility Classes
- GitHub Integration
- GitHub Actions Workflow
- Jenkins Freestyle Job
- Jenkins Pipeline
- CI/CD Ready

---

# 🏗 Project Structure

```
Enterprise-Selenium-Hybrid-Framework
│
├── .github
│   └── workflows
│       └── selenium-framework.yml
│
├── src
│
├── main
│   ├── java
│   │
│   ├── actions
│   ├── config
│   ├── constants
│   ├── driver
│   ├── enums
│   ├── exceptions
│   ├── logger
│   ├── models
│   ├── pages
│   ├── reports
│   └── utilities
│
│   └── resources
│       └── log4j2.xml
│
├── test
│   ├── java
│   │
│   ├── annotations
│   ├── base
│   ├── dataprovider
│   ├── listeners
│   ├── retry
│   ├── tests
│   └── utils
│
│   └── resources
│       ├── config-dev.properties
│       ├── config-qa.properties
│       ├── config-uat.properties
│       ├── config-prod.properties
│       ├── testdata
│       └── testng.xml
│
├── Jenkinsfile
├── pom.xml
├── README.md
└── .gitignore
```

---

# 🏛 Framework Architecture

```
TestNG Test

↓

BaseTest

↓

Driver Factory

↓

ThreadLocal Driver

↓

Page Objects

↓

Utilities

↓

Assertions

↓

Extent Reports

↓

Jenkins / GitHub Actions
```

---

# 🎯 Design Patterns Used

The framework follows industry-standard design patterns.

| Pattern | Purpose |
|----------|----------|
| Page Object Model | Maintainable Page Classes |
| Singleton | Config & Report Management |
| Factory Pattern | Browser Initialization |
| Builder Pattern | Future Extensibility |
| ThreadLocal Pattern | Parallel Execution |
| Utility Pattern | Common Reusable Methods |

---

# 📄 Page Object Model

Each application page is maintained separately.

Example:

```
LoginPage

HomePage

CheckoutPage

CartPage
```

Advantages

- Better Code Organization
- Easy Maintenance
- High Reusability
- Low Coupling

---

# 🚗 Driver Management

The framework uses ThreadLocal WebDriver for thread-safe execution.

Components

- DriverFactory
- DriverManager

Supported Browsers

- Chrome
- Edge
- Firefox

Supports

- Headed Execution
- Headless Execution
- Parallel Execution

---

# ⚙ Configuration Management

Execution is controlled using external configuration files.

Example

```
browser=chrome

headless=false

maximize=true

app.url=https://rahulshettyacademy.com/client
```

Multiple Environment Support

```
config-dev.properties

config-qa.properties

config-uat.properties

config-prod.properties
```

Run QA Environment

```
mvn clean test -Denv=qa
```

---

# 📚 Utility Classes

The framework provides reusable utility classes.

## Browser Utilities

- BrowserUtils
- WindowUtils
- FrameUtils
- AlertUtils

---

## Web Element Utilities

- ElementActions
- WaitUtils
- JavaScriptUtils
- MouseActionsUtils
- KeyboardActionsUtils

---

## Data Utilities

- ExcelUtils
- JsonUtils
- DateUtils
- RandomDataUtils

---

## Advanced Utilities

- ScreenshotUtils
- DownloadUtils
- FileUploadUtils
- TableUtils

---

## Browser Storage Utilities

- CookieUtils
- LocalStorageUtils
- SessionStorageUtils
- ShadowDomUtils

---

# 📊 Data Driven Testing

Supports two different approaches.

## Excel Data Provider

Uses Apache POI.

```
@DataProvider

ExcelDataProvider
```

---

## JSON Data Provider

Uses Jackson ObjectMapper.

```
@DataProvider

JsonDataProvider
```

---

# 📝 Logging

Uses Log4j2.

Features

- Console Logs
- File Logs
- Execution Tracking
- Debugging Support

---

# 📈 Reporting

Extent Reports are generated after every execution.

Features

- Pass
- Fail
- Skip
- Exception Stack Trace
- Screenshots
- Categories
- Timeline
- System Information

Report Location

```
test-output/ExtentReports/
```

---

# ✅ Assertions

Supports

- Hard Assertions
- Soft Assertions

Custom Utility

```
AssertionUtils
```

Soft Assertions are automatically collected and executed after each test.

---

# 🔁 Retry Mechanism

Automatically retries failed test cases.

Implemented using

```
RetryAnalyzer
```

Retry count is configurable using the configuration file.

---

# 🌐 Cross Browser Execution

Supported Browsers

- Chrome
- Firefox
- Edge

Examples

```
mvn clean test -Dbrowser=chrome
```

```
mvn clean test -Dbrowser=edge
```

```
mvn clean test -Dbrowser=firefox
```

---

# 🧵 Parallel Execution

Supports parallel execution using TestNG.

Example

```xml
<suite parallel="methods" thread-count="3">
```

Thread-safe execution is achieved using ThreadLocal WebDriver.

---

# 👻 Headless Execution

Run tests without opening the browser.

```
mvn clean test -Dheadless=true
```

Ideal for Jenkins and CI/CD pipelines.

---

# 📸 Screenshots

Automatic screenshot capture

- On Failure
- On Success (Configurable)

Location

```
test-output/screenshots/
```

---

# 🚀 Jenkins Integration

The framework is integrated with Jenkins Pipeline.

Pipeline Stages

- Checkout Source Code
- Clean Project
- Execute Tests
- Generate Reports
- Archive Reports
- Archive Screenshots

Supports

- Freestyle Jobs
- Pipeline Jobs

---

# ⚡ GitHub Actions

GitHub Actions workflow is included.

Features

- Automatic Build
- Maven Execution
- Test Execution
- CI Ready

Workflow Location

```
.github/workflows/selenium-framework.yml
```

---

# ▶️ Project Execution

Clone Repository

```
git clone https://github.com/someswar01/Enterprise-Selenium-Hybrid-Framework.git
```

Move into Project

```
cd Enterprise-Selenium-Hybrid-Framework
```

Install Dependencies

```
mvn clean install
```

Run Tests

```
mvn clean test
```

Run Chrome

```
mvn clean test -Dbrowser=chrome
```

Run Edge

```
mvn clean test -Dbrowser=edge
```

Run Firefox

```
mvn clean test -Dbrowser=firefox
```

Run Headless

```
mvn clean test -Dheadless=true
```

Run QA Environment

```
mvn clean test -Denv=qa
```

---

# 📂 Reports

After execution

```
test-output
```

Contains

- Extent Report
- Screenshots
- TestNG Reports

---

# 💡 Future Enhancements

- Selenium Grid
- Docker Integration
- BrowserStack Integration
- LambdaTest Integration
- REST Assured Integration
- Allure Reports
- Slack Notifications
- Email Notifications
- Azure DevOps Pipeline

---

# 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

If you find any issue or have ideas to improve the framework, feel free to fork the repository and create a pull request.

---

# 📄 License

This project is intended for learning, demonstration, and portfolio purposes. Feel free to use it as a reference for building enterprise automation frameworks.

---

# 👨‍💻 Author

**Somesh C**

Automation Test Engineer

### Skills

- Java
- Selenium WebDriver
- TestNG
- Maven
- REST Assured
- SQL
- Git & GitHub
- Jenkins
- CI/CD
- Page Object Model
- Hybrid Framework Development

---

# ⭐ Support

If you found this project helpful:

⭐ Star this repository

🍴 Fork this repository

📢 Share it with the automation testing community

Happy Testing! 🚀
