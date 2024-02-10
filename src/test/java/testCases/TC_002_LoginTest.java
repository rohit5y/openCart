package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	@Test(groups= {"sanity","master"},priority=2)
	public void loginTest() {
		try {
			logger.info("*** Starting TC_002_LoginTest ***");
			HomePage hp=new HomePage(driver);
			logger.info("Homepage class instance created");
			
			hp.clickMyAccount();
			logger.info("MyAccount button clicked");
			
			hp.clickLogin();
			logger.info("login button clicked");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("LoginPage class instance created");
			
			lp.setEmail(rb.getString("email"));
			logger.info("Email is entered");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Password is entered");
			
			lp.clickLogin();
			logger.info("login button clicked");
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean myAcc=macc.checkMyAccount();
			Assert.assertEquals(myAcc, true,"data passed is incorrect");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
		logger.info("*** TC_002_LoginTest Finished ***");
	}
	

}
