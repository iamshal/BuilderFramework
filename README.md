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
- **GitHub Actions** for CI/CD
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

## CI/CD
- **GitLab CI/CD**: `.gitlab-ci.yml`
- **GitHub Actions**: `.github/workflows/ci.yml`
- **Docker**: `Dockerfile` and `docker-compose.yml`

## Getting Started with GitLab

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

## Add your files

- [x] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [x] [Add files using the command line](https://docs.gitlab.com/topics/git/add_files/#add-files-to-a-git-repository) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.com/iamshal-group/iamshal-project.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [x] [Set up project integrations](https://gitlab.com/iamshal-group/iamshal-project/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/user/project/merge_requests/auto_merge/)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [x] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/)
- [x] [Analyze your code for known vulnerabilities with Static Application Security Testing (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)