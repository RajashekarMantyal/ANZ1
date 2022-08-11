Feature:  A Borrowing Calculator Feature


Scenario: Fill all the details in borrowing calculator
Given User is navigated to ANZ Calculator
When I Enter all the valid details
|ApplicationType|NumberOfDependants|PropertyLikeToBuy|AnnualIncome|AnnualOtherIncome|MonthlyLivingExpenses|CurrentMonthlyRepayments|OtherMonthlyRepayments|OtherMonthlyCommitments|TotalCreditCardLimit|
|Single|0|Home to live in|80000|10000|500|0|100|0|10000|
And Click on the BorrowCalculator Button
Then Validate the result 474000
And Close the browser

Scenario: Fill all the details and click on Start over
Given User is navigated to ANZ Calculator
When I Enter all the valid details
|ApplicationType|NumberOfDependants|PropertyLikeToBuy|AnnualIncome|AnnualOtherIncome|MonthlyLivingExpenses|CurrentMonthlyRepayments|OtherMonthlyRepayments|OtherMonthlyCommitments|TotalCreditCardLimit|
|Single|0|Home to live in|80000|10000|500|0|100|0|10000|
And Click on the BorrowCalculator Button
And Click on the Start Over button
Then Validate all the fields
|ApplicationType|NumberOfDependants|PropertyLikeToBuy|AnnualIncome|AnnualOtherIncome|MonthlyLivingExpenses|CurrentMonthlyRepayments|OtherMonthlyRepayments|OtherMonthlyCommitments|TotalCreditCardLimit|
|Single|0|Home to live in|0|0|0|0|0|0|0|
And Close the browser

Scenario: Enter only one field value and leave all the fiedls zero and check the estimate of your borrowing power
Given User is navigated to ANZ Calculator
When I Enter Monthly living expenses as 1
And Click on the BorrowCalculator Button
Then Validate the message as "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."
And Borrow button should not be displayed
And Close the browser
		