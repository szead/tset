# TSET Cucumber UI test framework

This is a homework project for TSET. 

# Pre-requisites:
 - java 8 or higher
 - gradle 7.5.1 or higher(wrapper included)
 - Run the https://github.com/tsetweb/tset-tester-challenge app first on localhost

# How to build before running tests

```bash
gradle clean build -x test
```

# Run with gradle on local environment
```shell
gradle pricing
```

# How to run by a specific test tag

```shell
gradle clean test -Dcucumber.filter.tags="@pricing" -Denvironment=local
```

You can add your own @tag on any scenario and only run that one. For example:
```shell
gradle clean test -Dcucumber.filter.tags="@test" -Denvironment=local
```

There is a gradle task for this behavior defined:
```shell
gradle singleTest
```

# Show the report
```shell
gradle showReport
```

# Test Scenarios
You can find the test scenarios in the following file:
```shell
src/test/resources/features/pricing/PricesOfComponents.feature
```

# Implementation
The implementation of the test scenarios can be found in the following file:
```shell
src/test/java/com/tset/pricing/stepdefs/PricesOfComponentsStepDefinitions.java
```

The components of the test framework can be found in the following files:
```shell
src/main/java/starter/pricecomponents/
``` 

Task are for the screenplay pattern actions and task.
UI is the Page object for the UI elements.