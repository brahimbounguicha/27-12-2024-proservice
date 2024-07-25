package TestSuites;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Helper.Utils;
import Pages.DellHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DellHomeStepDef {
	@Given("admin is on homepage")
	public void admin_is_on_homepage() throws Exception {
Config.confChrome();
Config.driver = new ChromeDriver();
Config.maximaseWindow();
Config.driver.get(Utils.getproprety("Web_Portal_Link"));

	}

	@When("admin mousehover on menu {string} and submenu {string}")
	public void admin_mousehover_on_menu_and_submenu(String menu, String submenu) throws Exception {
	    DellHome home = new DellHome();
	    home.mousehoverOnMenuByName(menu, submenu);
	}

	@When("admin click on produit {string}")
	public void admin_click_on_produit(String produitname) {
		DellHome home = new DellHome();
		home.clickOnProduct(produitname);
	}

	@Then("admin is directed to the page that contains message  {string}")
	public void admin_is_directed_to_the_page_that_contains_message(String ExpectedMessage) {
		DellHome home = new DellHome();
		String actualMessage = home.verifP();
		Assert.assertEquals(ExpectedMessage, actualMessage);
	}



}
