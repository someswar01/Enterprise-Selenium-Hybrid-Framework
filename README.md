# 🚀 Selenium Hybrid Automation Framework

An **Enterprise-Level Selenium Automation Framework** developed using **Java 21, Selenium 4, TestNG, Maven, and the Page Object Model (POM)**. The framework is designed by following industry best practices with a focus on **scalability, maintainability, reusability, and CI/CD readiness**.

It supports **cross-browser execution, parallel execution, data-driven testing, reusable utilities, ThreadLocal WebDriver management, Extent Reports, Log4j2 logging, and Jenkins integration**, making it suitable for real-world automation projects.

---

# 📌 Key Features

- Selenium 4 Web Automation
- Java 21
- TestNG Framework
- Maven Build Management
- Page Object Model (POM)
- ThreadLocal WebDriver Management
- Cross Browser Execution
- Parallel Test Execution
- Retry Failed Test Cases
- Soft Assertions
- Explicit Wait Utilities
- Screenshot Capture
- Extent HTML Reports
- Log4j2 Logging
- External Configuration Management
- Environment-Based Execution
- Excel Data-Driven Testing
- JSON Data-Driven Testing
- Browser Storage Utilities
- Shadow DOM Support
- Reusable Utility Classes
- GitHub Integration
- Jenkins CI/CD Ready

---

# 🛠 Technology Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Selenium | 4.x |
| TestNG | Latest |
| Maven | Latest |
| Apache POI | Latest |
| Jackson | Latest |
| Log4j2 | Latest |
| Extent Reports | Latest |
| WebDriverManager | Latest |

---

# 🏗 Framework Architecture

```
SeleniumHybridFramework
│
├── src
│
├── main
│   ├── java
│   │
│   ├── actions
│   ├── base
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
├── pom.xml
├── README.md
└── .gitignore
```

---

# 📂 Framework Modules

## Base Layer

The Base Layer contains the common setup and teardown methods used across all test classes.

Responsibilities:

- Browser initialization
- Browser termination
- Driver management
- Common test setup
- Common test cleanup

---

## Driver Layer

Responsible for browser creation and management using the **ThreadLocal Design Pattern**, enabling thread-safe parallel execution.

Components:

- DriverFactory
- DriverManager

Supported Browsers:

- Chrome
- Edge
- Firefox

---

## Configuration Layer

Application configuration is maintained externally using properties files.

Example:

```properties
browser=chrome
headless=false
maximize=true
app.url=https://rahulshettyacademy.com/client
```

Supports multiple execution environments:

```
config-dev.properties
config-qa.properties
config-uat.properties
config-prod.properties
```

Example Execution:

```bash
mvn clean test -Denv=qa
```

---

# 📄 Page Object Model (POM)

Each application page is implemented as a separate Java class.

Example:

```
LoginPage
HomePage
```

Benefits:

- Better maintainability
- High code reusability
- Easy maintenance
- Clear separation of page logic from test logic

---

# ⚙ Utility Classes

The framework provides reusable utility classes to simplify Selenium automation.

## Browser Utilities

- BrowserUtils
- WindowUtils
- FrameUtils
- AlertUtils

## Web Element Utilities

- ElementActions
- WaitUtils
- JavaScriptUtils
- MouseActionsUtils
- KeyboardActionsUtils
- DropdownUtils

## Data Utilities

- ExcelUtils
- JsonUtils
- DateUtils
- RandomDataUtils

## Browser Storage Utilities

- CookieUtils
- LocalStorageUtils
- SessionStorageUtils
- ShadowDomUtils

## Other Utilities

- TableUtils
- ScreenshotUtils

---

# 📊 Data-Driven Testing

The framework supports multiple data sources.

## Excel Data Provider

Implemented using **Apache POI**.

Example:

```
@DataProvider
ExcelDataProvider
```

## JSON Data Provider

Implemented using **Jackson ObjectMapper**.

Example:

```
@DataProvider
JsonDataProvider
```

---

# 📝 Logging

Log4j2 is used for logging framework execution.

Advantages:

- Console logging
- File logging
- Better debugging
- Easy execution tracking

---

# 📈 Reporting

The framework uses **Extent Reports** to generate interactive HTML reports.

Features:

- Passed Tests
- Failed Tests
- Skipped Tests
- Screenshots
- Exception Stack Trace
- Execution Timeline

---

# ✅ Assertions

Supports:

- Hard Assertions
- Soft Assertions

Custom Utility:

```
AssertionUtils
```

---

# 🔄 Retry Mechanism

Automatically retries failed test cases.

Implemented using:

```
RetryAnalyzer
```

Retry count can be configured in:

```
config.properties
```

---

# 🌐 Cross Browser Execution

Supported Browsers:

- Chrome
- Edge
- Firefox

Example:

```bash
mvn clean test -Dbrowser=edge
```

---

# ⚡ Parallel Execution

Parallel execution is supported using TestNG.

Example:

```xml
parallel="methods"
thread-count="3"
```

---

# 📸 Screenshots

Automatic screenshots can be captured:

- On Test Failure
- On Test Success (Configurable)

Output Location:

```
test-output/screenshots
```

---

# 📑 Reports

Execution reports are generated inside:

```
test-output/
```

Includes:

- Extent HTML Report
- Screenshots

---

# 🏛 Design Patterns Used

The framework follows industry-standard design patterns.

- Page Object Model (POM)
- ThreadLocal Pattern
- Factory Pattern
- Singleton Pattern
- Utility Pattern

---

# ⚠ Exception Handling

Custom exceptions improve debugging and framework readability.

Examples:

- FrameworkException
- BrowserException
- ConfigReaderException

---

# ▶ How to Execute

Clone Repository

```bash
git clone https://github.com/someswar01/SeleniumHybridFramework.git
```

Install Dependencies

```bash
mvn clean install
```

Run All Tests

```bash
mvn clean test
```

Run on Specific Browser

```bash
mvn clean test -Dbrowser=edge
```

Run on Specific Environment

```bash
mvn clean test -Denv=qa
```

---

# 🔄 Continuous Integration

The framework is designed for seamless CI/CD integration.

Supported Platforms:

- Jenkins
- GitHub Actions
- Azure DevOps

---

# 🚀 Future Enhancements

- Selenium Grid
- Docker
- BrowserStack Integration
- LambdaTest Integration
- REST Assured Integration
- Allure Reports
- GitHub Actions Pipeline

---

# 🎯 Advantages

- Scalable Framework Architecture
- Reusable Components
- Thread-Safe Execution
- Easy Maintenance
- Cross-Browser Support
- Data-Driven Testing
- Parallel Execution
- Enterprise Ready
- CI/CD Ready

---

# 👨‍💻 Developed By

**Somesh C**

**Automation Test Engineer**

**Skills**

- Java
- Selenium
- TestNG
- Maven
- Jenkins
- Git & GitHub
- SQL
- API Testing
- Automation Framework Development

---

## ⭐ If you found this project useful, consider giving it a Star on GitHub!