package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Utility;

public class BorrowCalculatorStepDefinition{

	 WebDriver driver;

	
	 @Given("^User is navigated to ANZ Calculator$")
	 public void navigateToURL(){
		 System.setProperty("webdriver.chrome.driver",".//Driver//chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(Utility.getData("URL"));
		 String title = driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("Home loan borrowing power calculator | ANZ", title);
	 }
	
	
	 @When("^I Enter all the valid details$")
	 public void enterDetails(DataTable usercredentials){
		 try {
			 List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
			 if(data.get(0).get("ApplicationType").equals("Single")) {
				 driver.findElement(By.id("application_type_single")).click();
			 }else if(data.get(0).get("ApplicationType").equals("Joint")){
				 driver.findElement(By.id("application_type_joint")).click();
			 }else {
				 assertTrue(false, "Application type is wrong");
			 }
			 
			 Select sel = new Select(driver.findElement(By.xpath("//*[@title='Number of dependants']")));
			 sel.selectByVisibleText(data.get(0).get("NumberOfDependants"));
			 
			 if(data.get(0).get("PropertyLikeToBuy").equals("Home to live in")) {
				 driver.findElement(By.id("borrow_type_home")).click();
			 }else if(data.get(0).get("PropertyLikeToBuy").equals("Residential investment")){
				 driver.findElement(By.id("borrow_type_investment")).click();
			 }else {
				 assertTrue(false, "Property like to buy is wrong");
			 }
			 
			 driver.findElement(By.xpath("//*[text()='Your annual income (before tax)']/parent::div/child::div/input"))
			 .sendKeys(data.get(0).get("AnnualIncome"));
			 
			 driver.findElement(By.xpath("//*[text()='Your annual other income (optional)']/parent::div/child::div/input"))
			 .sendKeys(data.get(0).get("AnnualOtherIncome"));
			 
			 driver.findElement(By.xpath("//*[text()='Monthly living expenses ']/parent::div/child::div/input"))
			 .sendKeys(data.get(0).get("MonthlyLivingExpenses"));
			 
			 driver.findElement(By.xpath("//*[contains(text(),'Current home loan monthly')]/parent::div/child::div/input"))
			 .sendKeys(data.get(0).get("CurrentMonthlyRepayments"));
			 
			 driver.findElement(By.xpath("//*[contains(text(),'Other loan monthly repayments')]/parent::div/child::div/input"))
			 .sendKeys(data.get(0).get("OtherMonthlyRepayments"));
			 
			 driver.findElement(By.xpath("//*[contains(text(),'Other monthly commitments')]/parent::div/child::div/input"))
			 .sendKeys(data.get(0).get("OtherMonthlyCommitments"));
			 
			 driver.findElement(By.xpath("//*[contains(text(),'Total credit card limits')]/parent::div/child::div/input"))
			 .sendKeys(data.get(0).get("TotalCreditCardLimit"));
			 
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
	 }
	
	 @And("^Click on the BorrowCalculator Button$")
	 public void click_on_Borrow_Calculator_Btn(){
		 try {
			 Thread.sleep(3000);
			 driver.findElement(By.id("btnBorrowCalculater")).click();
			 Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	 }
	
	 @Then("^Validate the result (\\d+)$")
	 public void validate_result(int result) {
		 try {
			 Thread.sleep(3000);
			 String borrowResult = driver.findElement(By.id("borrowResultTextAmount")).getText();
			 String borrowResultStr[] = borrowResult.split("\\$");
			 String borrowResult1[] = borrowResultStr[1].split(",");
			 String Result_UI = borrowResult1[0]+borrowResult1[1];
			 Assert.assertEquals(Integer.parseInt(Result_UI), result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 

	 @And("^Close the browser$")
	 public void close_the_browser(){
		 try {
			 driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 @And("^Click on the Start Over button$")
	 public void click_on_Start_Over_Btn(){
		 try {
			 Thread.sleep(3000);
			 WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Start over')]/span"));
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		     js.executeScript("arguments[0].click();",ele);
		     Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	 }
	
	 @When("^Validate all the fields$")
	 public void validateAllDetails(DataTable usercredentials){
		 try {
			 boolean val_all_details = false;
			 List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
			 if(data.get(0).get("ApplicationType").equals("Single")) {
				 val_all_details = driver.findElement(By.xpath("//*[@id='application_type_single']/ancestor::li[@class='selected']")).isDisplayed();
				 assertEquals(val_all_details, true);
			 }else if(data.get(0).get("ApplicationType").equals("Joint")){
				 driver.findElement(By.xpath("//*[@id='application_type_joint']/ancestor::li[@class='selected']")).isDisplayed();
				 assertEquals(val_all_details, true);
			 }else {
				 assertTrue(false, "Application type is wrong");
			}
			 
			 Select sel = new Select(driver.findElement(By.xpath("//*[@title='Number of dependants']")));
			 val_all_details = sel.getFirstSelectedOption().getText().equals(data.get(0).get("NumberOfDependants"));
			 assertEquals(val_all_details, true);
			 
			 
			 if(data.get(0).get("PropertyLikeToBuy").equals("Home to live in")) {
				 val_all_details = driver.findElement(By.xpath("//*[contains(text(),'Home to live in')]/ancestor::li[@class='selected']")).isDisplayed();
				 assertEquals(val_all_details, true);
			 }else if(data.get(0).get("PropertyLikeToBuy").equals("Residential investment")){
				 val_all_details = driver.findElement(By.xpath("//*[contains(text(),'Residential investment')]/ancestor::li[@class='selected']")).isDisplayed();
				 assertEquals(val_all_details, true);
			 }else {
				 assertTrue(false, "Property like to buy is wrong");
			 }
			 
			 val_all_details = driver.findElement(By.xpath("//*[text()='Your annual income (before tax)']/parent::div/child::div/input[@value="+data.get(0).get("AnnualIncome")+"]"))
			 .isDisplayed();
			 
			 assertEquals(val_all_details, true);
			 
			 val_all_details = driver.findElement(By.xpath("//*[text()='Your annual other income (optional)']/parent::div/child::div/input[@value="+data.get(0).get("AnnualOtherIncome")+"]"))
			 .isDisplayed();
			 
			 assertEquals(val_all_details, true);
			 
			 val_all_details = driver.findElement(By.xpath("//*[text()='Monthly living expenses ']/parent::div/child::div/input[@value="+data.get(0).get("MonthlyLivingExpenses")+"]"))
			 .isDisplayed();
			 
			 assertEquals(val_all_details, true);
			 
			 val_all_details = driver.findElement(By.xpath("//*[contains(text(),'Current home loan monthly')]/parent::div/child::div/input[@value="+data.get(0).get("CurrentMonthlyRepayments")+"]"))
			 .isDisplayed();
			 
			 assertEquals(val_all_details, true);
			 
			 val_all_details = driver.findElement(By.xpath("//*[contains(text(),'Other loan monthly repayments')]/parent::div/child::div/input[@value="+data.get(0).get("OtherMonthlyRepayments")+"]"))
			 .isDisplayed();
			 
			 assertEquals(val_all_details, true);
			 
			 val_all_details = driver.findElement(By.xpath("//*[contains(text(),'Other monthly commitments')]/parent::div/child::div/input[@value="+data.get(0).get("OtherMonthlyCommitments")+"]"))
			 .isDisplayed();
			 
			 assertEquals(val_all_details, true);
			 
			 val_all_details = driver.findElement(By.xpath("//*[contains(text(),'Total credit card limits')]/parent::div/child::div/input[@value="+data.get(0).get("TotalCreditCardLimit")+"]"))
			 .isDisplayed();
			 
			 assertEquals(val_all_details, true);
			 
			 val_all_details = driver.findElement(By.id("btnBorrowCalculater")).isDisplayed();
			 
			 assertEquals(val_all_details, true);
			 
		 }catch (Exception e) {
			e.printStackTrace();
		}		 
	 }
	 
	 @When("^I Enter Monthly living expenses as (\\d+)$")
	 public void i_Enter_Monthly_living_expenses_as(int expenseValue) {
	     try {
	    	 driver.findElement(By.xpath("//*[text()='Monthly living expenses ']/parent::div/child::div/input"))
			 .sendKeys(String.valueOf(expenseValue));
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

	 @Then("^Validate the message as \"([^\"]*)\"$")
	 public void validate_the_message(String exp_Err_Msg) {
		 try {
			 
			 String act_Err_Msg = driver.findElement(By.xpath("//*[@class='borrow__error__text']")).getText().trim();
			 assertEquals(act_Err_Msg, exp_Err_Msg, "Error message is didn't matched");
			 
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }

	 @Then("^Borrow button should not be displayed$")
	 public void borrow_button_should_not_be_displayed() {
		 boolean val_all_details = true;
		 try {
			 
			 val_all_details = driver.findElement(By.id("btnBorrowCalculater")).isDisplayed();
			 assertEquals(val_all_details, false, "Borrow calculator button is displayed after click on the borrow calculator button");
			 
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
}
