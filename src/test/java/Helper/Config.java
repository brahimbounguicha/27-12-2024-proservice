package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Config {
	
	public static WebDriver driver; 
	public static Actions actions;
	
	public static void confChrome() throws Exception {
		System.setProperty("webdriver.chrome.driver", Utils.getproprety("TestDriverPath"));
	}
	
	public static void maximaseWindow() {
		driver.manage().window().maximize();
	}
	

}
