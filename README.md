# Mutation Testing with PIT (Java)

## Overview
This README provides instructions for setting up and running mutation testing using the PIT (Pitest) tool for a Java project. The goal of the testing process is to evaluate the quality of unit and integration tests by introducing small mutations (faults) into the code and checking if the existing tests can detect these faults.

### Tools Used
- **PIT (Pitest)**: A mutation testing tool for Java that helps in assessing the effectiveness of your unit tests.
- **Maven**: Used for dependency management and running tests.

## Designed Test Cases

### Unit Testing
1. **Arithmetic Operator Replacement (AOR)**: Tests whether changes to arithmetic operators (e.g., `+`, `-`, `*`, `/`) are detected by the unit tests.
2. **Relational Operator Replacement**: Tests whether changes to relational operators (e.g., `>`, `<`, `==`, `!=`) are properly identified.
3. **Logical Operator Replacement**: Tests whether logical operators (e.g., `&&`, `||`) are correctly handled in unit tests.
4. **Shift Operator Replacement**: Ensures that changes to shift operators (e.g., `<<`, `>>`) are covered by unit tests.

### Integration Testing
1. **Integration Parameter Variable Replacement**: Tests the impact of replacing method parameter variables in integration tests.
2. **Integration Method Call Deletion**: Validates that deletion of method calls is covered by integration tests.
3. **Integration Return Expression Modification**: Ensures that modifications to return expressions in methods are detected by integration tests.

## How to Run Tests

### PIT Setup
1. Add the **PIT** (Pitest) plugin and dependency in your `pom.xml` file.

```xml
<dependency>
    <groupId>org.pitest</groupId>
    <artifactId>pitest</artifactId>
    <version>1.8.3</version> <!-- Use the latest version -->
    <scope>test</scope>
</dependency>

<build>
    <plugins>
        <plugin>
            <groupId>org.pitest</groupId>
            <artifactId>pitest-maven</artifactId>
            <version>1.8.3</version> <!-- Use the latest version -->
            <executions>
                <execution>
                    <goals>
                        <goal>mutationCoverage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

### Running Mutation Tests
To run mutation tests, execute the following Maven command in the terminal:

```bash
mvn org.pitest:pitest-maven:mutationCoverage
```

This command will trigger PIT to run mutation testing and generate the results.

### Viewing Reports
Once the mutation tests are completed, navigate to the generated reports:

1. Go to the `target/pit-reports` directory of your project.
2. Open the `index.html` file in your browser to view detailed mutation coverage and results.

## Test Results
Below is a screenshot of the mutation testing results (replace this section with your actual results screenshot or text report).

---

## Team Members and Contributions

### Aakash Bhardwaj (MT2023143)
- **Unit Testing**
- **Integration Testing**
### Kuldip Bhatale (MT2023087)
- **Unit Testing**
-  **Integration Testing**:
---

## Conclusion
Mutation testing using PIT helps ensure that the written test cases are effective in identifying faults and improving code coverage. By applying various mutations, we can assess the robustness of both unit and integration tests. This process plays a crucial role in enhancing the reliability of the software.
