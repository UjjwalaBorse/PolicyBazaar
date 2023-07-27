package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.Utility;

public class MyAccountPage {


@FindBy(xpath="//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']")private WebElement username;
@FindBy(className="h_l")private WebElement logoutButton;

//constructor
public MyAccountPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
//methods
public String getActualUserName() throws InterruptedException {
	Reporter.log("getting ActualUserName", true);
	Utility.wait(1000);
	String actualUN=username.getText();
	return actualUN;
	
}
public void clickOnLogOutButton() {
	Reporter.log("logging out",true);
	logoutButton.click();
}
}