package stepdefinitions;



import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pageobjects.AccountPage;
import com.pageobjects.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	 
	    List<Map<String, String>> credList = credTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage = loginpage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	   String title = accountPage.getAccountPageTitle();
	   System.out.println("Accounts page Title" + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		
	   List<String> expAccountSectionsList = sectionTable.asList();
	   System.out.println("Expected account section list :" + expAccountSectionsList);
	   
	   List<String> actAccountSectionsList = accountPage.getAccountSectionList();
	   System.out.println("Actual account section list :" + actAccountSectionsList);
	   
	   Assert.assertTrue(expAccountSectionsList.containsAll(actAccountSectionsList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	   Assert.assertTrue(accountPage.getAccountSectionCount() == expectedSectionCount );
	}



}
