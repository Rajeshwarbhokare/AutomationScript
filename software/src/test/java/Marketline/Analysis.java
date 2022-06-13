package Marketline;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Analysis {

	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static Date date=new Date();
	static SimpleDateFormat sd= new	 SimpleDateFormat("dd_MM_yyyy");
	String icNames;
	
	 @BeforeTest
	 public void launchBrowser()  
	        {  
			  report=new ExtentReports("Verifications__ML_Analysis" + sd.format(date) + ".html", false);
			  test=report.startTest("VerificationsOf_ML_Analysis");
			  System.out.println("ExtentReport");
		      }

       @BeforeClass
       public void loginGlobaldata ()
           {
    	   Analysis t = new Analysis();
              t.login();
             }
        

       @Test (priority=1)
       public void verify_industryprofile () throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	       test.log(LogStatus.PASS,"Verify Analysis"); 
  	      
  	       WebElement Industryanalysis = driver.findElement(By.xpath("//a[text()='Industry analysis']"));
	       act.moveToElement(Industryanalysis).click().build().perform();
	       test.log(LogStatus.PASS,"click on Industry analysis");
	       
	       WebElement Industryprofile = driver.findElement(By.xpath("//a[text()='Industry profiles']"));
	       act.moveToElement(Industryprofile).click().build().perform();
	     	     	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Industry Profiles'])[1]")));
	       test.log(LogStatus.PASS,"Industry Profile Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Industry Profile page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Industry Profile page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Industry Profile page  not available");			
		}
	}   
       
       @Test (priority=2)
       public void verify_industryprofilearchive () throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[text()='Industry Profiles - Archive']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform(); 
  	      
  	       WebElement Industryanalysis = driver.findElement(By.xpath("//a[text()='Industry analysis']"));
	       act.moveToElement(Industryanalysis).click().build().perform();
	   
	       WebElement Industryprofilearchive = driver.findElement(By.xpath("//a[text()='Industry Profiles - Archive']"));
	       Industryprofilearchive.click();
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Industry Profile – Archive']")));
	       test.log(LogStatus.PASS,"Industry Profile  - Archive Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Industry Profile - Archive page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Industry Profile  - Archive page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Industry Profile  - Archive page  not available");			
		}
	}   
      
   	
       @Test (priority=3)
       public void verify_industrychartbook () throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("(//a[text()='Industry Chartbooks'])[2]")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform(); 
  	      
  	       WebElement Industryanalysis = driver.findElement(By.xpath("//a[text()='Industry analysis']"));
  	     act.moveToElement(Industryanalysis).click().build().perform();
  	        Thread.sleep(1000);
	   
	       WebElement Industryprofilechartbook = driver.findElement(By.xpath("(//a[text()='Industry Chartbooks'])[1]"));
	       act.moveToElement(Industryprofilechartbook).click().build().perform();
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@class='lead']")));
	       test.log(LogStatus.PASS,"Industry Chartbook Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Industry Chartbooks page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Industry Chartbookspage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Industry Chartbooks page  not available");			
		}
	}   
             

       @Test (priority=4)
       public void verify_industrycasestudies () throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("(//a[text()='Industry Case Studies'])[1]")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform(); 
  	      
  	       WebElement Industryanalysis = driver.findElement(By.xpath("//a[text()='Industry analysis']"));
  	       act.moveToElement(Industryanalysis).build().perform();
  	        Thread.sleep(1000);
	       WebElement Industryprofilechartbook = driver.findElement(By.xpath("(//a[text()='Industry Case Studies'])[1]"));
	       act.moveToElement(Industryprofilechartbook).click().build().perform();
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Industry Case Studies'])[1]")));
	       test.log(LogStatus.PASS,"Industry Case Studies Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Industry Case Studies page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Industry Case Studies page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Industry Case Studies page  not available");			
		}
	}  
       
       
       @Test (priority=5)
       public void verify_valueandsupplychainanalysis () throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[text()='value & supply chain Analysis']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform(); 
  	      
  	       WebElement Industryanalysis = driver.findElement(By.xpath("//a[text()='Industry analysis']"));
	       act.moveToElement(Industryanalysis).click().build().perform();
	   
	       WebElement Industryprofilechartbook = driver.findElement(By.xpath("//a[text()='value & supply chain Analysis']"));
	       act.moveToElement(Industryprofilechartbook).click().build().perform();
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Value & Supply Chain Analysis'])[1]")));
	       test.log(LogStatus.PASS,"value & supply chain Analysis Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "value & supply chain Analysis page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "value & supply chain Analysis page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "value & supply chain Analysis page  not available");			
		}
	}  
       
       
       @Test (priority=6)
       public void verify_componyanalysis () throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	        	      
  	       WebElement companyanalysis = driver.findElement(By.xpath("//a[text()='Company Analysis']"));
	       act.moveToElement(companyanalysis).click().build().perform();
	       test.log(LogStatus.PASS,"Company analysis");
	       
	       WebElement companyprofile = driver.findElement(By.xpath("//a[text()='Company Profiles']"));
	       act.moveToElement(companyprofile).click().build().perform();
	    	      	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=' Company Listing']")));
	       test.log(LogStatus.PASS,"Company Profile Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Industry Profile page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Industry Profile page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Industry Profile page  not available");			
		}
	}   
       
       
       @Test (priority=7)
       public void verify_companycasestudies() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	      
  	      
  	       WebElement companyanalysis = driver.findElement(By.xpath("//a[text()='Company Analysis']"));
	       act.moveToElement(companyanalysis).click().build().perform();
	     
	       
	       WebElement companycasestudies = driver.findElement(By.xpath("(//a[text()='Company Case Studies'])[1]"));
	       act.moveToElement(companycasestudies).click().build().perform();
	     	       	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Company Case Studies'])[1]")));
	       test.log(LogStatus.PASS,"Company Case Studies Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Company Case Studies page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Company Case Studies page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Company Case Studies page  not available");			
		}
	}   
       
       
       @Test (priority=8)
       public void verify_ThemeReports() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
	     	       
	       WebElement themereports = driver.findElement(By.xpath("//a[text()='Theme Reports']"));
	       act.moveToElement(themereports).click().build().perform();
	     	       	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Thematic Analysis'])[1]")));
	       test.log(LogStatus.PASS,"Theme Reports Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Theme Reports page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Theme Reports page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Theme Reports page  not available");			
		}
	}   
                 
       
       @Test (priority=9)
       public void verify_casestudiesarchives() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	        	      
  	       WebElement casestudies = driver.findElement(By.xpath("//a[text()='Case Studies']"));
  	       act.moveToElement(casestudies).build().perform();
	     	       
	       WebElement casestudyarchivess = driver.findElement(By.xpath("//a[text()='Case Study – Archive']"));
	       act.moveToElement(casestudyarchivess).click().build().perform();
	     	       	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Case Study – Archive'])[1]")));
	       test.log(LogStatus.PASS,"Case Study Archive Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Case Study – Archive page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Case Study  Archive page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Case Study Archive page  not available");
			
		}
	} 
       
       
       @Test (priority=10)
       public void verify_countriescities() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	      	      
  	       WebElement countriescities = driver.findElement(By.xpath("(//a[text()='Countries & Cities'])[2]"));
  	       act.moveToElement(countriescities).build().perform();
	       test.log(LogStatus.PASS,"Countries and Cities");
	       
	       WebElement countryprofile = driver.findElement(By.xpath("//a[text()='country profiles']"));
	       act.moveToElement(countryprofile).click().build().perform();
	       	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Country Profiles'])[1]")));
	       test.log(LogStatus.PASS,"country profiles Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "country profiles  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "country profiles  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "country profiles  page  not available");
			
		}
	} 
            

       @Test (priority=11)
       public void verify_countryriskreports() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	       	      
  	       WebElement countriescities = driver.findElement(By.xpath("(//a[text()='Countries & Cities'])[2]"));
  	       act.moveToElement(countriescities).build().perform();
	      	       
	       WebElement countryriskreports = driver.findElement(By.xpath("//a[text()='country & risk Reports']"));
	       act.moveToElement(countryriskreports).click().build().perform();	       
	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Country & Risk Reports'])[1]")));
	       test.log(LogStatus.PASS,"country & risk Reports Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "country & risk Reports  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "country & risk Reports  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "country & risk Reports page  not available");
			
		}

	} 
       
       @Test (priority=12)
       public void verify_cityprofile() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	        	      
  	       WebElement countriescities = driver.findElement(By.xpath("(//a[text()='Countries & Cities'])[2]"));
  	       act.moveToElement(countriescities).build().perform();
	      	       
	       WebElement cityprofile = driver.findElement(By.xpath("//a[text()='city profiles']"));
	       act.moveToElement(cityprofile).click().build().perform();
       	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='City Profiles']")));
	       test.log(LogStatus.PASS,"city profiles Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "city profiles  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "city profiles  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "city profiles page  not available");
			
		}

	}
       
       
       @Test (priority=13)
       public void verify_countrychartbook() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	       	      
  	       WebElement countriescities = driver.findElement(By.xpath("(//a[text()='Countries & Cities'])[2]"));
  	       act.moveToElement(countriescities).build().perform();
	    	       
	       WebElement countrychartbook = driver.findElement(By.xpath("(//a[text()='Country Chartbooks'])[1]"));
	       act.moveToElement(countrychartbook).click().build().perform();
	       	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Country Chartbooks'])[1]")));
	       test.log(LogStatus.PASS,"Country Chartbooks Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Country Chartbooks  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Country Chartbooks  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Country Chartbooks page  not available");
			
		}
	} 
      
       
       @Test (priority=14)
       public void verify_citychartbook() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	      
  	       WebElement countriescities = driver.findElement(By.xpath("(//a[text()='Countries & Cities'])[2]"));
  	       act.moveToElement(countriescities).build().perform();
	              
	       WebElement citychartbook = driver.findElement(By.xpath("(//a[text()='City Chartbooks'])[1]"));
	       act.moveToElement(citychartbook).click().build().perform();	       
	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='City Chartbooks'])[1]")));
	       test.log(LogStatus.PASS,"City Chartbooks Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "City Chartbooks  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "City Chartbooks  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "City Chartbooks page  not available");
			
		}
	} 
            
       @Test (priority=15)
       public void verify_analystinsights() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform(); 	      
  	      
  	       WebElement analystinsights = driver.findElement(By.xpath("//a[text()='analyst insights']"));
  	       act.moveToElement(analystinsights).click().build().perform();
	      	        
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Analyst Insights'])[1]")));
	       test.log(LogStatus.PASS,"analyst insights Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "analyst insights  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "analyst insights  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "analyst insights page  not available");			
		}
	} 
       
       @Test (priority=16)
       public void verify_Interactivemodels() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	       	    	       	       
	       WebElement Interactivemodels = driver.findElement(By.xpath("//a[text()='Interactive Models']"));
	       act.moveToElement(Interactivemodels).click().build().perform();
	       	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Interactive Models'])[1]")));
	       test.log(LogStatus.PASS,"Interactive Models Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Interactive Models  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Interactive Models  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Interactive Models page  not available");			
		}
	}
       

       @Test (priority=17)
       public void verify_Industrychartbook() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	      
  	     WebElement chartbooks = driver.findElement(By.xpath("//a[text()='chartbooks']"));
	       act.moveToElement(chartbooks).build().perform();
	       
	       
	       WebElement Industrychartbook = driver.findElement(By.xpath("(//a[text()='Industry Chartbooks'])[2]"));
	       act.moveToElement(Industrychartbook).click().build().perform();
	      	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Industry Chartbooks'])[1]")));
	       test.log(LogStatus.PASS,"Industry Chartbooks Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Industry Chartbooks  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Industry Chartbooks  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Industry Chartbooks page  not available");
			
		}
	}
       
       @Test (priority=18)
       public void verify_companychartbook() throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@id='Analysismenu']"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(analysis).build().perform();
  	      
  	      WebElement chartbooks = driver.findElement(By.xpath("//a[text()='chartbooks']"));
	       act.moveToElement(chartbooks).build().perform();
	       	       
	       WebElement companychartbook = driver.findElement(By.xpath("(//a[text()='Company chartbooks'])[1]"));
	       act.moveToElement(companychartbook).click().build().perform();
	              
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Company Chartbooks'])[1]")));
	       test.log(LogStatus.PASS,"Company chartbooks Page loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Company chartbooks  page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Company chartbooks  page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Company chartbooks page  not available");			
		}
	}
       
                         
        @AfterTest
        public void closeBrawser() {
    	        System.out.println("close Browser");
    	        report.endTest(test);
      	        report.flush();
   	        driver.quit();	
               }

        public void login () {
        	WebDriverManager.edgedriver().setup();
	 		driver=new EdgeDriver();
		 	driver.manage().window().maximize();
		 	driver.get("https://advantage.marketline.com");
		 	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 	driver.findElement(By.id("loginDetails_UserName")).sendKeys("Rajeshwar.bhokare@globaldata.com");
		 	driver.findElement(By.id("loginDetails_Password")).sendKeys("Shambhu@L0g!n123");
		 	driver.findElement(By.id("loginSubmit")).click();
		 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='GlobalData Intelligence Centers']")));  
		 	test.log(LogStatus.PASS, "Marketline HomePage displayed successfully");
		 			 	    
       	}//
        

   public static String capture(WebDriver driver) throws IOException 
   {
   	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   	File Dest = new File(".//target//ExtentReports//screenshots//" + System.currentTimeMillis()+ ".png");
   	String errflpath = Dest.getAbsolutePath();
   	FileUtils.copyFile(scrFile, Dest);
       return errflpath;
   }
   }