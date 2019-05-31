package com.bae.BDDTest.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bae.BDDTests.constants.Constant;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tests {
	static WebDriver driver;

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

	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals("http://www.practiceselenium.com/welcome.html", Constant.URL1);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().to(Constant.URL1);
		WebElement menuButton = driver.findElement(By.partialLinkText("Menu"));
		menuButton.click();
		WebElement menuText = driver
				.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1"));
		assertEquals(menuText.getText(), "Menu");

	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Boolean tea1Exist = driver
				.findElement(By
						.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong"))
				.isDisplayed();
		Boolean tea2Exist = driver
				.findElement(By
						.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong"))
				.isDisplayed();
		Boolean tea3Exist = driver
				.findElement(By
						.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong"))
				.isDisplayed();

		assertTrue(tea1Exist && tea2Exist && tea3Exist);
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().to(Constant.URL1);
		WebElement checkoutButton = driver
				.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
		checkoutButton.click();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement checkoutText = driver.findElement(
				By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451989411\"]/div/p/span/strong"));
		assertTrue(checkoutText.getText().contains("Pay with Credit Card or LogIn"));
	}

}
