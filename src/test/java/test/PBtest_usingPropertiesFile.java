package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom.LoginPage;
import pom.MyAccountPage;
import utility.Utility;
//@Listeners(myPropertyFile.Listener.class)
public class PBtest_usingPropertiesFile extends Base {
	LoginPage login;
	MyAccountPage myAcc;
	String TCID="PB_TC_410";
	
	@BeforeClass
	
		public void launchPolicyBazar() throws InterruptedException, IOException {
	   Utility.wait(100);
	   launchBrowserUsingPropertyFile();
	   login=new LoginPage(driver);
	   myAcc=new MyAccountPage(driver);
	      
	}
	@BeforeMethod
	public void signInToPolicyBazaar() throws InterruptedException, EncryptedDocumentException, IOException {
		Utility.wait(1000);
		login.clickOnHomePageSignInButton();
		Utility.wait(1000);
		login.enterMobileNum(Utility.readDataFromPropertyFile("mobNum"));
		Utility.wait(1000);
		login.signInwithPassword();
		Utility.wait(1000);
		login.password(Utility.readDataFromPropertyFile("pwd"));
		Utility.wait(1000);
		login.clickOnSignInButton();
		Utility.wait(1000);
		login.myAccount();
		Utility.wait(1000);
		login.myProfile();
		Utility.wait(1000);
		
		Set<String>allPageId=driver.getWindowHandles();
		List<String>l=new ArrayList<>(allPageId);
		String mainPageID=l.get(0);
		String childPageID=l.get(1);
		
		driver.switchTo().window(childPageID);
		Reporter.log("switching to child page",true);
		Utility.wait(1000);
		
	}
	
	
	
  @Test
  public void validateUserName() throws InterruptedException, EncryptedDocumentException, IOException {
	  Utility.wait(1000);
	  String actualUN=myAcc.getActualUserName();
	  String expUN=Utility.readDataFromPropertyFile("UN");
	  
	  Assert.assertEquals(actualUN, expUN,"TC is Failed, Actual and expected are not matching");
	 // Utility.takeScreenShot(driver, actualUN+""+TCID);
	    
  }
  @AfterMethod
  public void logOutFromPolicyBazaar() {
	  myAcc.clickOnLogOutButton();
  }
  @AfterClass
 public void closePolicyBazaar() {
	  closeBrowser();
  }
}



