Feature: simulate consumer loan

  Scenario Outline:  successful simulation
    Given I am on the simulation website
    Then I select my job type as "<jobType>"
    And I enter my monthly pay as "<monthlyPay>" and other monthly income as "<otherMonthlyIncome>"
    And I enter my monthly property charges as "<monthlyPropertyCharges>" and other monthly charges as "<otherMonthlyCharges>"
    And I enter the loan amount as "<loanAmount>"
    And I enter my birthday as "<birthday>" and loan duration as "<loanDuration>"
    And I provide my first name as "<firstname>" and last name as "<lastname>"
    And i set my email to "<email>"
    And I provide my phone number as "<phoneNumber>"
    And I accept the legal terms
    And I enter the OTP
    Then the mensualite should be "<mensualite>"
    Examples:
      | jobType       | monthlyPay | otherMonthlyIncome | monthlyPropertyCharges | otherMonthlyCharges | loanAmount | loanDuration | firstname | lastname | birthday | email              | phoneNumber | mensualite
      | fonctionnaire | 15000      | 2500               | 0                      | 0                   | 570000     | 35           | Boutouil  | Ilias    | 27121987 | boutouil@gmail.com | 612004567   | 50000
