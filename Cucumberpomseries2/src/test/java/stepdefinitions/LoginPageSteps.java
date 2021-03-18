package stepdefinitions;

import org.junit.Assert;

import com.pageobjects.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	   }

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		
		title = loginpage.getLoginPageTitle();
		System.out.println("Login page title is :" +title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		
		 Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		
	    Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username ) {
	    loginpage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    loginpage.enterPwd(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    loginpage.clickSignButton();
	}

	



}
