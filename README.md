# TSET Cucumber UI test framework

This is a homework project for TSET. 

# Pre-requisites:
 - java 8 or higher

# How to build before running tests

```bash
# gradle clean build -x test
```

# How to run all tests

```shell
gradle clean test -Dcucumber.filter.tags="@pricing" -Denvironment=local

```