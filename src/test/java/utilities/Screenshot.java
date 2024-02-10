package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.BaseClass;

public class Screenshot extends BaseClass{
	public void getScreenshot(String file) throws IOException {
		String path=System.getProperty("user.dir")+"\\screenshots\\";
		path+=file;
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(path);
		FileUtils.copyFile(src, trg);
	}

}
