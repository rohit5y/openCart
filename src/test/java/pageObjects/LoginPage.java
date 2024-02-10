package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement logEmail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement logPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	public void setEmail(String email) {
		logEmail.sendKeys(email);
	}
	
	public void setPassword(String pass) {
		logPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}

}
