package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProv;
import utilities.ExcelUtils;

public class TC_003_LoginDDT extends BaseClass {
	@Test
	public void loginTest() {
		try {
			logger.info("*** Starting TC_002_LoginTest ***");
			HomePage hp=new HomePage(driver);
			logger.info("Homepage class instance created");
			String path=".\\testData\\Opencart_LoginData.xlsx";
			
			hp.clickMyAccount();
			logger.info("MyAccount button clicked");
			
			hp.clickLogin();
			logger.info("login button clicked");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("LoginPage class instance created");
			
			lp.setEmail(ExcelUtils.getCellData(path, "sheet1", 1, 0));
			logger.info("Email is entered");
			
			lp.setPassword(ExcelUtils.getCellData(path, "sheet1", 1, 1));
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
