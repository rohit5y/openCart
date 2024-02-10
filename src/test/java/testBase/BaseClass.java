package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.Screenshot;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public FileInputStream fi;
	public Properties prop;
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters({"browser","os"})
	public void setup(String br,String os) throws IOException {
		rb=ResourceBundle.getBundle("config");
		prop=new Properties();
		fi=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		prop.load(fi);
		logger=LogManager.getLogger(this.getClass());
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os");
				return;
			}
			
			if(br.equalsIgnoreCase("chrome")) {
				capabilities.setBrowserName("chrome");
			}
			else if(br.equalsIgnoreCase("edge")) {
				capabilities.setBrowserName("Micosoft Edge");
			}
			else {
				System.out.println("No matching browser");
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		else if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			if(br.equals("chrome")) {
				driver=new ChromeDriver();
			}
			else if(br.equals("edge")) {
				driver=new EdgeDriver();
			}
			else {
				driver=new FirefoxDriver();
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(prop.getProperty("appurl1"));
		driver.get(rb.getString("appurl1"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
//	public String captureScreen(String tname) {
//		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		return timeStamp;
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		ts.getScreenshotAs(null);
//		
//	}
	
	public String randomString() {
		String name=RandomStringUtils.randomAlphabetic(5);
		return name;
	}
	public String randomEmail() {
		String name=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(5);
		return (name+num+"@gmail.com");
	}
	

}
