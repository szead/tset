@pricing
Feature: Prices of Components

  In order to calculate the total cost of a part it is necessary to understand the pricing structure of the underlying material.
  How a material is priced depends on negotiations with suppliers, and is broken down into multiple “price components”.
  The amount of these components varies, and the sum of all components will define the final price.

  Scenario: Changing the base price
    Given TSET has seen the base price value "1.0"
    When she changes the value to "5"
    Then she should see that the valus has been changed
    And the sum of all components should be "5"

  Scenario: Add all price components from Testdata shows correct summary
    Given TSET has seen the base price value "1.0"
    When she adds all price components from Testdata
      | Label title        | Price value |
      | Alloy surcharge    | 2.15        |
      | Scrap surcharge    | 3.14        |
      | Internal surcharge | 0.7658      |
      | External surcharge | 1           |
      | Storage surcharge  | 0.3         |
    Then she should see all data has been added

  Scenario: Remove price component of Internal surcharge
    Given TSET has seen the base price value "1.0"
    When she adds all price components from Testdata
      | Label title        | Price value |
      | Alloy surcharge    | 2.15        |
      | Scrap surcharge    | 3.14        |
      | Internal surcharge | 0.7658      |
      | External surcharge | 1           |
      | Storage surcharge  | 0.3         |
    And she removes the price component of Internal surcharge
    Then she should see that the price component of Internal surcharge has been removed
    And the sum of all components should be ""

  Scenario: Label input validation without check: label too short
    Given TSET has seen the base price value "1.0"
    When she adds all price components from Testdata
      | Label title        | Price value |
      | Alloy surcharge    | 2.15        |
      | Scrap surcharge    | 3.14        |
      | Internal surcharge | 0.7658      |
      | External surcharge | 1           |
      | Storage surcharge  | 0.3         |
    And she edits the price component of Storage surcharge with "T"
    Then she should see label contains at least 2 characters error message

  Scenario: Label input validation with check: label restored
    Given TSET has seen the base price value "1.0"
    When she adds all price components from Testdata
      | Label title        | Price value |
      | Alloy surcharge    | 2.15        |
      | Scrap surcharge    | 3.14        |
      | Internal surcharge | 0.7658      |
      | External surcharge | 1           |
      | Storage surcharge  | 0.3         |
    And she edits the price component of Storage surcharge with "T"
    And saves the value
    Then she should see label contains the original value

  Scenario: Value input validation without check: value cannot be negative
    Given TSET has seen the base price value "1.0"
    When she adds all price components from Testdata
      | Label title        | Price value |
      | Alloy surcharge    | 2.15        |
      | Scrap surcharge    | 3.14        |
      | Internal surcharge | 0.7658      |
      | External surcharge | 1           |
      | Storage surcharge  | 0.3         |
    And she edits the price component of Scrap surcharge with "-2.15"
    Then she should see value cannot be negative error message

  Scenario: Value input validation with check: value restored
    Given TSET has seen the base price value "1.0"
    When she adds all price components from Testdata
      | Label title        | Price value |
      | Alloy surcharge    | 2.15        |
      | Scrap surcharge    | 3.14        |
      | Internal surcharge | 0.7658      |
      | External surcharge | 1           |
      | Storage surcharge  | 0.3         |
    And she edits the price component of Scrap surcharge with "-2.15"
    And saves the value
    Then she should see value contains the original value



