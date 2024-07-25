package TestSuites;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Helper.Config;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class CommunStepDef {
	
	
	@After
	public void tearDown(Scenario sc) {
	if(sc.isFailed()) {
		File screenShotSource = ((TakesScreenshot)Config.driver).getScreenshotAs(OutputType.FILE);
		
		File screenshotDestination = new File("c:\\fieledSCDell.png");
		
		try {
			FileUtils.copyFile(screenShotSource, screenshotDestination);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	}

}
