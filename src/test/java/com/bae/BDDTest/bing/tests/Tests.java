package com.bae.BDDTest.bing.tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tests {
	static WebDriver driver;
	static String searchTerm;

	@Before
	public static void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public static void tearDown() {
		driver.quit();
	}

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().to(arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		searchTerm = arg1;
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("sb_form_q"))).click().sendKeys(searchTerm)
				.moveToElement(driver.findElement(By.id("sb_form_go"))).click().perform();
		// WebElement submitFunc = (new WebDriverWait(driver, 10))
		// .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"sb_sbi_gh\"]")));
		// WebElement searchBox = driver.findElement(By.id("sb_form_q"));
		// searchBox.sendKeys(searchTerm);
		// // Thread.sleep(200);
		// searchBox.submit();
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement pageConfirm = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("b_results")));
		assertTrue(pageConfirm.getText().contains(searchTerm));
	}

}
