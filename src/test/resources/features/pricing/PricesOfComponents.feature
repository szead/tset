@pricing
Feature: Prices of Components

  In order to calculate the total cost of a part it is necessary to understand the pricing structure of the underlying material.
  How a material is priced depends on negotiations with suppliers, and is broken down into multiple “price components”.
  The amount of these components varies, and the sum of all components will define the final price.

  Scenario: Base Price is shown correctly
    Given TSET has seen the price components
    Then she should see the base price with value "1.0"

  Scenario: Changing the base price
    Given TSET has seen the price components
    When she changes the value of the Baseprice to "5"
    Then she should see the base price with value "5.0"
    And she should see the sum of all components is "5.00"

  Scenario: Add all price components from Testdata shows correct summary and price
    Given TSET has seen the price components
    When she adds all price components from Testdata
      | LabelTitle         | PriceValue |
      | Alloy surcharge    | 2.15       |
      | Scrap surcharge    | 3.14       |
      | Internal surcharge | 0.7658     |
      | External surcharge | 1          |
      | Storage surcharge  | 0.3        |
    Then she should see all data has been added correctly
      | LabelTitle         | PriceValue |
      | Alloy surcharge    | 2.15       |
      | Scrap surcharge    | 3.14       |
      | Internal surcharge | 0.77       |
      | External surcharge | 1.0        |
      | Storage surcharge  | 0.3        |
    And she should see the sum of all components is "8.36"

  Scenario: Remove price component of Internal surcharge
    Given TSET has seen the price components
    When she adds all price components from Testdata
      | LabelTitle         | PriceValue |
      | Alloy surcharge    | 2.15       |
      | Scrap surcharge    | 3.14       |
      | Internal surcharge | 0.7658     |
      | External surcharge | 1          |
      | Storage surcharge  | 0.3        |
    And she removes the price component of Internal surcharge
    And she should see the sum of all components is "7.59"

  Scenario: Label input validation without check: label too short
    Given TSET has seen the price components
    When she adds all price components from Testdata
      | LabelTitle         | PriceValue |
      | Alloy surcharge    | 2.15       |
      | Scrap surcharge    | 3.14       |
      | Internal surcharge | 0.7658     |
      | External surcharge | 1          |
      | Storage surcharge  | 0.3        |
    And she edits the price component of Storage surcharge with "T"
    Then she should see label contains at least 2 characters error message

  Scenario: Label input validation with check: label restored
    Given TSET has seen the price components
    When she adds all price components from Testdata
      | LabelTitle         | PriceValue |
      | Alloy surcharge    | 2.15       |
      | Scrap surcharge    | 3.14       |
      | Internal surcharge | 0.7658     |
      | External surcharge | 1          |
      | Storage surcharge  | 0.3        |
    And she edits the price component of Storage surcharge with "T"
    And saves the value
    Then she should see label contains the original value

  Scenario: Value input validation without check: value cannot be negative
    Given TSET has seen the price components
    When she adds all price components from Testdata
      | LabelTitle         | PriceValue |
      | Alloy surcharge    | 2.15       |
      | Scrap surcharge    | 3.14       |
      | Internal surcharge | 0.7658     |
      | External surcharge | 1          |
      | Storage surcharge  | 0.3        |
    And she edits the price component of Scrap surcharge with "-2.15"
    Then she should see value cannot be negative error message

  Scenario: Value input validation with check: value restored
    Given TSET has seen the price components
    When she adds all price components from Testdata
      | LabelTitle         | PriceValue |
      | Alloy surcharge    | 2.15       |
      | Scrap surcharge    | 3.14       |
      | Internal surcharge | 0.7658     |
      | External surcharge | 1          |
      | Storage surcharge  | 0.3        |
    And she edits the price component of Scrap surcharge with "-2.15"
    And saves the value
    Then she should see value contains the original value



