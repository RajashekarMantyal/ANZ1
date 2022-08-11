$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BorrowCalculator.feature");
formatter.feature({
  "line": 1,
  "name": "A Borrowing Calculator Feature",
  "description": "",
  "id": "a-borrowing-calculator-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Fill all the details in borrowing calculator",
  "description": "",
  "id": "a-borrowing-calculator-feature;fill-all-the-details-in-borrowing-calculator",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is navigated to ANZ Calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I Enter all the valid details",
  "rows": [
    {
      "cells": [
        "ApplicationType",
        "NumberOfDependants",
        "PropertyLikeToBuy",
        "AnnualIncome",
        "AnnualOtherIncome",
        "MonthlyLivingExpenses",
        "CurrentMonthlyRepayments",
        "OtherMonthlyRepayments",
        "OtherMonthlyCommitments",
        "TotalCreditCardLimit"
      ],
      "line": 7
    },
    {
      "cells": [
        "Single",
        "0",
        "Home to live in",
        "80000",
        "10000",
        "500",
        "0",
        "100",
        "0",
        "10000"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Click on the BorrowCalculator Button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Validate the result 474000",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.navigateToURL()"
});
formatter.result({
  "duration": 9779950048,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.enterDetails(DataTable)"
});
formatter.result({
  "duration": 2085003919,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.click_on_Borrow_Calculator_Btn()"
});
formatter.result({
  "duration": 6220598693,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "474000",
      "offset": 20
    }
  ],
  "location": "BorrowCalculatorStepDefinition.validate_result(int)"
});
formatter.result({
  "duration": 3028964764,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.close_the_browser()"
});
formatter.result({
  "duration": 673718656,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Fill all the details and click on Start over",
  "description": "",
  "id": "a-borrowing-calculator-feature;fill-all-the-details-and-click-on-start-over",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "User is navigated to ANZ Calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I Enter all the valid details",
  "rows": [
    {
      "cells": [
        "ApplicationType",
        "NumberOfDependants",
        "PropertyLikeToBuy",
        "AnnualIncome",
        "AnnualOtherIncome",
        "MonthlyLivingExpenses",
        "CurrentMonthlyRepayments",
        "OtherMonthlyRepayments",
        "OtherMonthlyCommitments",
        "TotalCreditCardLimit"
      ],
      "line": 16
    },
    {
      "cells": [
        "Single",
        "0",
        "Home to live in",
        "80000",
        "10000",
        "500",
        "0",
        "100",
        "0",
        "10000"
      ],
      "line": 17
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Click on the BorrowCalculator Button",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Click on the Start Over button",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Validate all the fields",
  "rows": [
    {
      "cells": [
        "ApplicationType",
        "NumberOfDependants",
        "PropertyLikeToBuy",
        "AnnualIncome",
        "AnnualOtherIncome",
        "MonthlyLivingExpenses",
        "CurrentMonthlyRepayments",
        "OtherMonthlyRepayments",
        "OtherMonthlyCommitments",
        "TotalCreditCardLimit"
      ],
      "line": 21
    },
    {
      "cells": [
        "Single",
        "0",
        "Home to live in",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "line": 22
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.navigateToURL()"
});
formatter.result({
  "duration": 6381894228,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.enterDetails(DataTable)"
});
formatter.result({
  "duration": 1285788275,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.click_on_Borrow_Calculator_Btn()"
});
formatter.result({
  "duration": 6082521349,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.click_on_Start_Over_Btn()"
});
formatter.result({
  "duration": 6060590665,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.validateAllDetails(DataTable)"
});
formatter.result({
  "duration": 369856292,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.close_the_browser()"
});
formatter.result({
  "duration": 654362196,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Enter only one field value and leave all the fiedls zero and check the estimate of your borrowing power",
  "description": "",
  "id": "a-borrowing-calculator-feature;enter-only-one-field-value-and-leave-all-the-fiedls-zero-and-check-the-estimate-of-your-borrowing-power",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "User is navigated to ANZ Calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I Enter Monthly living expenses as 1",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Click on the BorrowCalculator Button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Validate the message as \"Based on the details you\u0027ve entered, we\u0027re unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "Borrow button should not be displayed",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.navigateToURL()"
});
formatter.result({
  "duration": 7995567799,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 35
    }
  ],
  "location": "BorrowCalculatorStepDefinition.i_Enter_Monthly_living_expenses_as(int)"
});
formatter.result({
  "duration": 158824027,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.click_on_Borrow_Calculator_Btn()"
});
formatter.result({
  "duration": 6131952696,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Based on the details you\u0027ve entered, we\u0027re unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.",
      "offset": 25
    }
  ],
  "location": "BorrowCalculatorStepDefinition.validate_the_message(String)"
});
formatter.result({
  "duration": 31704914,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.borrow_button_should_not_be_displayed()"
});
formatter.result({
  "duration": 27088219,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalculatorStepDefinition.close_the_browser()"
});
formatter.result({
  "duration": 614835449,
  "status": "passed"
});
});