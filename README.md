
Rest Assured Framework
This repository contains a framework built using the Rest Assured library for automating API testing. Rest Assured simplifies testing REST APIs by providing an intuitive and readable DSL (Domain Specific Language).

Table of Contents
Getting Started
Prerequisites
Installation
Project Structure
Running Tests
Using Maven
Using TestNG
Configuration
Writing Tests
Reporting
Contributing
License
Getting Started
Prerequisites
To use this framework, you need to have the following installed on your machine:

Java 8 or later
Maven
A text editor or an IDE (e.g., IntelliJ IDEA)
Installation

Clone the repository:
bash
Copy code
git clone https://github.com/lakshmi-devi/CurlAPI.git

│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pojo/          # Configuration classes (e.g., API endpoints)
│   └── test/
│       └── java/
│           ├── tests/           # Test classes
│           ├── utils/           # Utility classes (e.g., Request builders, Response validators)
│           └── resources/       # Test resources (e.g., JSON files, data sets)
│
├── pom.xml                      # Maven POM file with dependencies and build configuration
└── README.md                    # Project documentation (this file)
Running Tests
You can run the tests using Maven or directly through testNg.xml file.

Using Maven
To run all tests:
bash
Copy code
mvn test

To run a specific test class:
bash
Copy code
mvn -Dtest=TestClassName test
Using TestNG
We can also run tests through IDE using the TestNG plugin.

Configuration
The project can be configured via the Properties file. This includes:

Base URI: The base URI for API endpoints.
Endpoints: Define specific API endpoints that will be used across tests.


Used RequestSpecification define reusable requests.
Used TestNG annotation for assertions to validate API responses.
Reporting using Extent Report framework.

The framework integrates with extent report dependency for reporting. After running the tests, you can view the test report by navigating to reports folder for the HTML report.

![Screenshot (55)](https://github.com/user-attachments/assets/66ad8721-2580-498e-bc2f-6a5bd537c4d0)
![Screenshot (56)](https://github.com/user-attachments/assets/aa911c2b-3a5a-4c22-a1db-02d4e22771e0)
![Screenshot (58)](https://github.com/user-attachments/assets/69d3ebdd-4b2a-4bc8-bb9f-c190645455fd)
![Screenshot (57)](https://github.com/user-attachments/assets/69cb1f4b-0748-416d-b6d8-4de12ad38a36)






