package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {
//variable
	@FindBy(xpath = "//a[text()='Sign in']")private WebElement signInButtonHomePage;
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNumberField;
	@FindBy(xpath ="(//span[text()='Sign in with Password'])[2]")private WebElement SignInWithPassword;
	@FindBy(name="password")private WebElement passwordField;
	@FindBy(xpath="//span[text()='Sign in']")private WebElement SignInButton;
	@FindBy(xpath="//div[text()='My Account']")private WebElement MyAccountButton;
	@FindBy(xpath="//span[text()=' My profile ']")private WebElement MyProfileButton;	
	
	
	// constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//methods
	public  void clickOnHomePageSignInButton() {
		Reporter.log("Clicking on Home Page 'Sign In' Button", true);
		signInButtonHomePage.click();
	}
	public void enterMobileNum(String mobNum)
	{
		Reporter.log("entering mobile number",true);
		mobileNumberField.sendKeys(mobNum);
	}
	public void signInwithPassword() {
		Reporter.log("clicking on SignInwithPassword button",true);
		SignInWithPassword.click();
	}
	public void password(String pwd) {
		Reporter.log("Entering Password",true);
		passwordField.sendKeys(pwd);
	}
	public void clickOnSignInButton() {
		Reporter.log("clicking on SignInButton",true);
		SignInButton.click();
	}
	public void myAccount() {
		Reporter.log("Clicking on MyAccount Button",true);
		MyAccountButton.click();
	}
	public void myProfile() {
		Reporter.log("Clicking on MyProfile Button",true);
		MyProfileButton.click();
	}
	
	
	
	
	
	}
	

