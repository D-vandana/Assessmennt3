package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageobject.AboutUs;
import com.pageobject.FeesAndPayment;
import com.pageobject.GiftCards;
import com.pageobject.HomePage;
import com.pageobject.LoginPage;
import com.pageobject.SearchPage;
import com.pageobject.Shipping;
import com.pageobject.SofaPage;
import com.pageobject.StudyClass;
import com.utility.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MainClass extends BaseClass
{	
	WebDriver driver=null;
	@Given("user Open the Browser")
	public void user_open_the_browser()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser opened");
	}
	@When("Enter into the {string} website")
	public void enter_into_the_website(String site)
	{
		driver.get(site);
		System.out.println("Website Done");
	}
	@Given("user click on Login page")
	public void user_click_on_login_page()
	{
		hp = new HomePage(driver);
	    hp.icon().click();
	    hp.Login().click();
	    System.out.println("Login Page opened");
	}
	@Given("Enter {string} and {string}")
	public void enter_and(String email, String Pwd) throws Exception
	{
		lp = new LoginPage(driver);
		Thread.sleep(5000);
		lp.emailID().sendKeys(email);
		Thread.sleep(2000);
		lp.pass().sendKeys(Pwd);
		lp.enter().click();
		System.out.println("Login Done");
	}
	@Then("close the website")
	public void close_the_website()
	{
		driver.quit();
		System.out.println("Browser Quit");		
	}
	@Given("user need to type Study Table in search bar")
	public void user_need_to_type_study_table_in_search_bar() throws Exception
	{
	    hp = new HomePage(driver);
		Thread.sleep(5000);
		hp.search().sendKeys("Study Table");
		hp.searchIcon().click();
	}

		
	@Given("verify whether Study Table keyword in that page")
	public void verify_whether_Study_Table_keyword_in_that_page() throws Exception
	{
		sp = new SearchPage(driver);
		Thread.sleep(5000);
		Assert.assertEquals(sp.studyVerify().getText(),"Search Results For 'Study Table'");
		System.out.println("Study table Verified");
	}

	@Given("click on Study link")
	public void click_on_study_link() throws Exception
	{
		sp = new SearchPage(driver);
		Thread.sleep(2000);
		sp.study().click();
		System.out.println("clicked on study link");
	}
	@Given("click on Office Tables")
	public void click_on_office_tables() throws Exception
	{
		Thread.sleep(5000);
		sp.officeTable().click();
		System.out.println("Clicked on Office Table");
	}
	@Given("Verify whether the Office Table Keyword is featured or not")
	public void verify_whether_the_office_table_keyword_is_featured_or_not() throws Exception
	{
		sc = new StudyClass(driver);
		Thread.sleep(5000);
		Assert.assertEquals(sc.tableVerify().getText(), "Office Tables");
		System.out.println("Officetables Verified");
	}
	@Given("click on Fee & Payment")
	public void click_on_fee_payment() throws Exception
	{
		sb = new SofaPage(driver);
		sb.feesandpayment().click();
		Thread.sleep(2000);
		fp= new FeesAndPayment (driver);
		System.out.println("Clicked on study Link ");
	}
	@Given("verify whether TERMS OF SHIPPING AND DELIVERY is featured or not")
	public void verify_whether_terms_of_shipping_and_delivery_is_featured_or_not() throws Exception
	{
		fp= new FeesAndPayment (driver);
		Thread.sleep(2000);
		Assert.assertEquals (fp.FAPVerify().getText(),"FEES AND PAYMENT OPTIONS");
		Thread.sleep(2000);
		System.out.println("Office Verification Done");
	}
	@Given("user click on Gift Cards")
	public void user_click_on_gift_cards()
	{
		fp= new FeesAndPayment (driver);
		fp.giftCards().click();
		System.out.println("study Link Done");
	}
	@Given("verify whether First, choose an occasion is available or not")
	public void verify_whether_first_choose_an_occasion_is_available_or_not() throws Exception
	{
		gc = new GiftCards(driver);
		Thread.sleep(5000);
		Assert.assertEquals(gc.gcVerify().getText(),"1. First, choose an occasion");
		System.out.println("GiftCard Verification Done");
	}
	@Given("user click on About Us page")
	public void user_click_on_about_us_page()
	{
		gc = new GiftCards(driver);
		gc.aboutUs ().click();	
		System.out.println("AboutUs Link Done");
	}
	@Then("verify whether  Honesty & Transparency is appropriate or not")
	public void verify_whether_honesty_transparency_is_appropriate_or_not() throws Exception
	{
		au = new AboutUs(driver);
		Thread.sleep(5000);
		Assert.assertTrue(au.aboutVerify().getText().contains("Honesty & Transparency"));
		System.out.println("About Verification Done");
	}
	@Given("click on Shipping link")
	public void click_on_shipping_link()
	{
		sh = new Shipping(driver);
		sh.shipping().click();
		System.out.println("Clicked on Shipping Link ");
	}
	@Given("Verify whether the TERMS OF SHIPPING AND DELIVERY is featured or not")
	public void verify_whether_the_terms_of_shipping_and_delivery_is_featured_or_not() throws Exception
	{
		sh = new Shipping(driver);
		Thread.sleep(5000);
		Assert.assertEquals(sh.shippingVerify().getText(), "TERMS OF SHIPPING AND DELIVERY");
		System.out.println("Shipping Verified");
	}
	@Given("user click on TV Units")
	public void user_click_on_tv_units() throws Exception
	{
		au = new AboutUs(driver);
		Thread.sleep(5000);
		au.tvunits().click();
		System.out.println(" Clicked on TVUnit ");
	}
	@Given("verify whether TV Units is present or not in the page")
	public void verify_whether_tv_units_is_present_or_not_in_the_page()
	{
	   System.out.println(" TVUnit verified");
	}
}
