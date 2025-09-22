# Test Automation Framework

## Features
- **Selenium WebDriver** for UI testing
- **RestAssured** for API testing
- **Kafka** for event testing
- **TestNG** for test execution
- **Allure & Extent** for reporting
- **WireMock & MockServer** for mocking
- **MySQL** for database validation
- **Docker** for environment setup
- **GitLab CI/CD** for continuous integration
- **Page Object Model** pattern
- **Builder** pattern

## Setup
1. Clone repository
2. Run `mvn clean install`
3. Start services: `docker-compose up -d`
4. Run tests: `mvn test`

## Test Structure
- UI Tests: `src/test/java/com/testautomation/tests/ui/`
- API Tests: `src/test/java/com/testautomation/tests/api/`
- Kafka Tests: `src/test/java/com/testautomation/tests/kafka/`
- Database Tests: `src/test/java/com/testautomation/tests/database/`
- Mocking Tests: `src/test/java/com/testautomation/tests/mocking/`

## Reports
- Allure: `target/site/allure-maven-plugin/`
- Extent: `test-output/ExtentReport.html`
