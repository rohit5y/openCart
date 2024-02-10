package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-newsletter']")
	WebElement newsletterNo;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreePolicy;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement cont;
	
	public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void setEmail(String em) {
		email.sendKeys(em);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickNewsLetterrNo() {
		newsletterNo.click();
	}
	
	public void clickAgreePolicy() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", agreePolicy);
//		agreePolicy.click();
	}
	
	public void clickContinue() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cont);
//		cont.click();
	}
	

}
