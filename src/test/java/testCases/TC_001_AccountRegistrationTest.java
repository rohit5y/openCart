package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.Screenshot;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"regression","master"},priority=1)
	public void test_Account_Registration() {
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("click on myaccount done");
			
			hp.clickRegister();
			logger.info("click on registeraccount done");
			
			AccountRegistrationPage ac=new AccountRegistrationPage(driver);
//			ac.setFirstName(prop.getProperty("username"));
			ac.setFirstName(rb.getString("username"));
			logger.info("Firstname is passed");
			
			ac.setLastName("wed");
			logger.info("Lastname is passed");
			
			ac.setEmail(rb.getString("email"));
			logger.info("Email is passed");
			
			ac.setPassword(rb.getString("password"));
			logger.info("Password is passed");
			
			ac.clickNewsLetterrNo(); 
			logger.info("NewsLetter is enabled");
			
			ac.clickAgreePolicy();
			logger.info("Agree policy is clicked");
			
			ac.clickContinue();
			logger.info("Continue button is clicked`	");
//			Thread.sleep(3000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
