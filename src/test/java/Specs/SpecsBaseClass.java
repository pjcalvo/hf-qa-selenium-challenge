package Specs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SpecsBaseClass extends SuperBaseClass{

    @Parameters ({"environment","baseURL"})
    @BeforeMethod ()
    public void InitializeTests(@Optional String environment, @Optional String baseUrl) throws MalformedURLException {

        if (environment == null )
            environment = "chrome";
        if (baseUrl == null)
            baseUrl = "http://automationpractice.com/index.php";
        
        setDriver(getDriver(environment));
      
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        InitHelpers(baseUrl);
        InitPages();

        driver().get(DriverHelper.baseUrl);
    }

    @AfterMethod
    public  void CleanUpDriver(ITestResult result){
    	if(ITestResult.FAILURE==result.getStatus()){
    		 try{
    			 captureScreenshot(result.getName());
    		 }
    		 catch (Exception e){
    			 System.out.println("Exception while taking screenshot "+e.getMessage());
    		 }
    	}
    			  			 
    	driver().close();
        driver().quit();
    } 
        
    public void captureScreenshot(String testCaseName) {
    	TakesScreenshot screenshot=(TakesScreenshot)driver();
    	 File src=screenshot.getScreenshotAs(OutputType.FILE);
    	 try {
			FileUtils.copyFile(src, new File("/errorShots/"+ testCaseName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
    
    private WebDriver getDriver(String environment) {
    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-mac-64bit");
    	System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-mac-64bit");
      	
    	if (environment.equals("chrome"))
            return new ChromeDriver();
        else
            return new FirefoxDriver();
    	
    }
}
