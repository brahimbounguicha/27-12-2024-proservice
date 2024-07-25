package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class DellHome {
	
	@FindBy(xpath="/html/body/div[5]/header/section/header/div[2]/div[2]/nav/ul/li/button/span")
	List<WebElement> menus ;
	
	@FindBy(xpath="/html/body/div[5]/header/section/header/div[2]/div[2]/nav/ul/li[3]/ul/li/button")
    
	List<WebElement> submenus;
	
	@FindBy(xpath="/html/body/div[5]/header/section/header/div[2]/div[2]/nav/ul/li[3]/ul/li[3]/ul/li/a")
	
	List<WebElement> ProduitList;
	
	@FindBy(xpath="/html/body/main/div[2]/section[2]/div[1]/div/div/h1/span")
	WebElement vpage ;
	
	public DellHome() {
		PageFactory.initElements(Config.driver, this);
	}
	
	public void mousehoverOnMenuByName(String menuName, String subMenuName) throws Exception {
		Thread.sleep(6000);
		for(WebElement menu:menus) {
			System.out.println(menu.getText());
			if(menu.getText().contains(menuName)) {
				Config.actions= new Actions(Config.driver);
				Config.actions.moveToElement(menu).perform();
				Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				for(WebElement submenu:submenus) {
					if(submenu.getText().contains(subMenuName)) {
						Config.actions.moveToElement(submenu).perform();
						
					}
				}
			}
		}
	}
	public void clickOnProduct(String produitName) {
		try {
		for(WebElement produit:ProduitList) {
			if(produit.getText().contains(produitName)) {
				produit.click();
			}
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String verifP() {
		String actualMessage = vpage.getText();
		return actualMessage;
	}
}
