package test;



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

public class Publicsector {

	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static Date date=new Date();
	static SimpleDateFormat sd= new	 SimpleDateFormat("dd_MM_yyyy");
	String icNames;
	
	 @BeforeTest
	 public void launchBrowser()  
	        {  
			  report=new ExtentReports("Verificationof_Publicsector" + sd.format(date) + ".html", false);
			  test=report.startTest("Verificationof_Publicsector");
			  System.out.println("ExtentReport");
		      }

       @BeforeClass
       public void loginGlobaldata ()
           {
    	      Publicsector t = new Publicsector();
              t.login();
             }
       
       
       

       @Test (priority=1)
       public void verifypublicsector () throws InterruptedException, IOException {
    	     
    	       if(driver.findElements(By.xpath("//span[@class='icon xx-large left gd-construction-institutional']")).size()>0)
    	             {
    	    	   try
    				 {
    	   WebElement publicsector = driver.findElement(By.xpath("//span[@class='icon xx-large left gd-construction-institutional']"));
    	   publicsector.click();  
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Analysis']")));
  		   test.log(LogStatus.INFO,"Public Sector"); 
  		 test.log(LogStatus.PASS,"Public Sector homepage loaded successfully"); 
  		   Thread.sleep(1000);
    				 }
    	    	   catch(Exception co)
    				{
    						 test.log(LogStatus.FAIL, "Public Sector homepage failed to  load ");
    						 test.log(LogStatus.INFO, co.getMessage());
    						 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Public Sector homepage failed to  load ");	
    					}
    				 }
    				else
    				{
    					     test.log(LogStatus.PASS, "Public Sector homepage  page not available");
    					
    				}

    			}
       @Test (priority=2)
       public void verifyorganisation () throws InterruptedException, IOException  {
    	   
    	   if(driver.findElements(By.xpath("(//a[@href='/organisation/index'])[1]")).size()>0)
           {
  	   try
			 {
    	   WebElement organisation = driver.findElement(By.xpath("(//a[@href='/organisation/index'])[1]"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(organisation).build().perform();
  	       test.log(LogStatus.PASS,"Organizations homepage loaded successfully"); 
  	       Thread.sleep(1000);
  	       WebElement customer = driver.findElement(By.xpath("//a[@href='/Organisation/Index?tab=Customer']"));
	       act.moveToElement(customer).click().build().perform();
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@id='customise-th-customername']")));
	       test.log(LogStatus.PASS,"Customers homepage loaded successfully");  	
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Customers homepage failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Customers homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Customers homepage  page not available");
			
		}

	}   //
       
       @Test (priority=3)
       public void verifysupplier () throws InterruptedException, IOException  {
    	   
    	   if(driver.findElements(By.xpath("(//a[@href='/organisation/index'])[1]")).size()>0)
           {
  	   try
			 {
    	    WebElement organisation = driver.findElement(By.xpath("(//a[@href='/organisation/index'])[1]"));  
    	    Actions act = new Actions(driver);
  	        act.moveToElement(organisation).build().perform();
  	        Thread.sleep(1000);
    	    WebElement supplier = driver.findElement(By.xpath("//a[@href='/Organisation/Index?tab=Supplier']"));
    	    act.moveToElement(supplier).click().build().perform();   
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@class='nosort sorting_disabled']")));
  		    test.log(LogStatus.PASS,"Supplier homepage loaded successfully");  
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Supplier homepage failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Supplier homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Supplier homepage  page not available");
			
		}

	}    //
       
       @Test (priority=4)
       public void verifysector () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	    WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	    test.log(LogStatus.PASS,"Sectors homepage loaded successfully "); 
    	    Actions act = new Actions(driver);
    	    act.moveToElement(sector).build().perform();
    	    test.log(LogStatus.INFO,"Total 9 Sector");
    	    Thread.sleep(1000);
    	     WebElement centralgovernment = driver.findElement(By.xpath("//a[text()='Central Government']"));
    	     act.moveToElement(centralgovernment).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Central Government']")));
  		     test.log(LogStatus.PASS,"Central government overview Page loaded successfully");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Central government homepage failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Central government homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Central government homepage  page not available");
			
		}

	}   
       
       @Test (priority=5)
       public void verifyEducation () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	     WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	     Actions act = new Actions(driver);
    	     act.moveToElement(sector).build().perform();	   
    	     Thread.sleep(1000);
    	     WebElement education = driver.findElement(By.xpath("//a[text()='Education']"));
    	     act.moveToElement(education).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Education']")));
  		     test.log(LogStatus.PASS,"Education overview Page loaded successfully");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Education overview page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Education overview homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Education overview homepage  page not available");
			
		}

	}   
      
       
       @Test (priority=6)
       public void verifyHealthcare () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	     WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	     Actions act = new Actions(driver);
    	     act.moveToElement(sector).build().perform();
    	     Thread.sleep(1000);
    	     WebElement healthcare = driver.findElement(By.xpath("//a[text()='Healthcare']"));
    	     act.moveToElement(healthcare).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Healthcare']")));
  		     test.log(LogStatus.PASS,"Healthcare Oerview Page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Healthcare Oerview page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Healthcare Oerview homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Healthcare Oerview homepage  page not available");
			
		}

	}    
       
       @Test (priority=7)
       public void verifyTransport () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	     WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	     Actions act = new Actions(driver);
    	     act.moveToElement(sector).build().perform();
    	     Thread.sleep(1000);
    	     WebElement transport = driver.findElement(By.xpath("//a[text()='Transport']"));
    	     act.moveToElement(transport).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Transport']")));
  		     test.log(LogStatus.PASS,"Transport overview Sector Page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Transport Oerview page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Transport Oerview homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Transport Oerview homepage  page not available");
			
		}

	}
       @Test (priority=8)
       public void verifyLocalGovernment () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	     WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	     Actions act = new Actions(driver);
    	     act.moveToElement(sector).build().perform();
    	     Thread.sleep(1000);
    	     WebElement localgovernment = driver.findElement(By.xpath("//a[text()='Local Government']"));
    	     act.moveToElement(localgovernment).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Local Government']")));
  		     test.log(LogStatus.PASS,"Local Government overview Sector Page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Local Government Oerview page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Local Government Oerview homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Local Government Oerview homepage  page not available");
			
		}

	} 
	  
       @Test (priority=9)
       public void verifyPolice () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	     WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	     Actions act = new Actions(driver);
    	     act.moveToElement(sector).build().perform();
    	     Thread.sleep(1000);
    	     WebElement Police = driver.findElement(By.xpath("//a[text()='Police']"));
    	     act.moveToElement(Police).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Police']")));
  		     test.log(LogStatus.PASS,"Police overview Sector Page loaded successfully");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Police Oerview page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Police Oerview homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Police Oerview homepage  page not available");
			
		}

	} 
 	  
       @Test (priority=10)
       public void verifyUtilities () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	   WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(sector).build().perform();
    	   Thread.sleep(1000);
    	   WebElement utilities = driver.findElement(By.xpath("//a[text()='Utilities']"));
    	   act.moveToElement(utilities).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Utilities']")));
  		   test.log(LogStatus.PASS,"Utilities overview Sector Page loaded successfully ");  		 
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Utilities Oerview page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Utilities Oerview homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Utilities Oerview homepage  page not available");
			
		}

	} 
       
       @Test (priority=11)
       public void verifyRegulatoryBodies () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	   WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(sector).build().perform();
    	   Thread.sleep(1000); 
    	   WebElement regulatoryBodies = driver.findElement(By.xpath("//a[text()='Regulatory Bodies']"));
    	   act.moveToElement(regulatoryBodies).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Regulatory Bodies']")));
  		   test.log(LogStatus.PASS," Regulatory Bodies overview Sector Page loaded successfully");  		 
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Regulatory Bodies Oerview page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Regulatory Bodies Oerview homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Regulatory Bodies Oerview homepage  page not available");
			
		}

	}  
       
       @Test (priority=12)
       public void verifyNonProfitOrganizations () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Sector/Index']")).size()>0)
           {
  	   try
			 {
    	   WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(sector).build().perform();
    	   Thread.sleep(1000);
    	   WebElement nonProfitOrganizations  = driver.findElement(By.xpath("//a[text()='Non-Profit Organizations']"));
    	   act.moveToElement(nonProfitOrganizations).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Non-Profit Organizations']")));
  		   test.log(LogStatus.PASS,"Non-Profit Organizations Overview Sector Page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Non-Profit Organizations Oerview page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Non-Profit Organizations Oerview homepage failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Non-Profit Organizations Oerview homepage  page not available");
			
		}

	}  
        
       
       @Test (priority=13)
       public void verifyDatabase () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
           {
  	   try
			 {
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   test.log(LogStatus.PASS,"Database homepage loaded successfully");  	
    	   Thread.sleep(1000);
    	   WebElement opportunities  = driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]"));
    	   act.moveToElement(opportunities).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Opportunities Database']")));
  		   test.log(LogStatus.PASS," Opportunities Database page loaded successfully  ");  		
  		   driver.navigate().back();
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Opportunities Database page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Opportunities Database page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Opportunities Database page  page not available");
			
		}

	}      
       
       
       @Test (priority=14)
       public void verifyPreProcurement () throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
           {
  	   try
			 {
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
    	   WebElement preProcurement  = driver.findElement(By.xpath("//a[text()='Pre-Procurement']"));
    	   act.moveToElement(preProcurement).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Pre-Procurement Database']")));
  		   test.log(LogStatus.PASS," Pre-Procurement Database page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Pre-Procurement Database page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Pre-Procurement Database page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Pre-Procurement Database page  page not available");
			
		}

	}      
          
       
       
       @Test (priority=15)
       public void verifyMarketanalyzers() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
           {
  	   try
			 {
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
    	    WebElement marketanalyzers  = driver.findElement(By.xpath("//a[text()='Market Analyzers']"));
    	    act.moveToElement(marketanalyzers).click().build().perform();
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Market Analyzers']")));
  		    test.log(LogStatus.PASS," Market Analyzers Page loaded successfully  ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Market Analyzers Database page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Market Analyzers Database page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Market Analyzers Database page  page not available");
			
		}

	}      
            
       
       @Test (priority=16)
       public void verifymarketdashboard() throws InterruptedException, IOException{
    	   if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
           {
  	   try
			 {
    	   
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
    	   WebElement marketmarketdashboard  = driver.findElement(By.xpath("//a[text()='Market Dashboard']"));
    	   act.moveToElement(marketmarketdashboard).click().build().perform();  
           WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Public Sector']")));	 
      	   test.log(LogStatus.PASS,"Market Dashboard Page loaded successfully"); 
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Market Dashboard Database page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Market Dashboard Database page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Market Dashboard Database page  page not available");
			
		}

	} 
       
       @Test (priority=17)
       public void veriycityeconomics() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
           {
  	   try
			 {
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   database.click();
    	   Thread.sleep(1000);
    	   JavascriptExecutor js =(JavascriptExecutor)driver;
    	   js.executeScript("window.scrollBy(0,300)");
    	   WebElement cityeconomics  = driver.findElement(By.xpath("//a[text()=' City Economics']"));
    	   cityeconomics.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='City Economics']")));
  		   test.log(LogStatus.PASS,"City Economics page loaded successfully"); 
  		   
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "City Economics Database page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "City Economics Database page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "City Economics Database page  page not available");
			
		}

	} 
       
 
       
       @Test (priority=18)
       public void veriycityprofile() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
           {
  	   try
			 {
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   database.click();
    	   Thread.sleep(1000);
    	   JavascriptExecutor js =(JavascriptExecutor)driver;
    	   js.executeScript("window.scrollBy(0,300)");
    	   WebElement cityprofile  = driver.findElement(By.xpath("//a[text()=' City Profiles']"));
    	   cityprofile.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='City Profiles']")));
  		   test.log(LogStatus.PASS,"City profile page loaded successfully");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "City profile Database page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "City profile Database page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "City profile Database page  page not available");
			
		}

	} 
         
       
       @Test (priority=19)
       public void verifyAnalysis() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Analysis/Search']")).size()>0)
           {
  	   try
			 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis/Search']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(analysis).build().perform();
    	   test.log(LogStatus.PASS,"Analysis homepage loaded successfully "); 
    	   Thread.sleep(1000);
    	    WebElement custemeranalysis  = driver.findElement(By.xpath("//a[text()='Customer Analysis']"));
    	    act.moveToElement(custemeranalysis).click().build().perform();
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Analysis']")));
  		    test.log(LogStatus.PASS," Customers Analysis page loaded Successfully");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, " Customers Analysis page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ " Customers Analysis page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Customers Analysis page not available");
			
		}

	}     
        
       @Test (priority=20)
       public void verifySupplierAnalysis() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Analysis/Search']")).size()>0)
           {
  	   try
			 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis/Search']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(analysis).build().perform();
    	   Thread.sleep(1000);
    	   WebElement supplieranalysis  = driver.findElement(By.xpath("//a[text()='Supplier Analysis']"));
    	   act.moveToElement(supplieranalysis).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Analysis']")));
  		   test.log(LogStatus.PASS,"Supplier Analysis page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Supplier Analysis page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Supplier Analysis page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Supplier Analysis page not available");
			
		}

	}       
       
       @Test (priority=21)
       public void verifyInsideandTrends() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Analysis/Search']")).size()>0)
           {
  	   try
			 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis/Search']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(analysis).build().perform();
    	   Thread.sleep(1000);
    	    WebElement insideandTrends  = driver.findElement(By.xpath("//a[text()='Insights & Trends']"));
    	    act.moveToElement(insideandTrends).click().build().perform();
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Analysis']")));
  		    test.log(LogStatus.PASS,"Insights & Trends Analysis page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Insights & Trends Analysis page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Insights & Trends Analysis page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Insights & Trends Analysis page not available");
			
		}

	}    
       
       @Test (priority=22)
       public void verifyModelsandForecasts() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Analysis/Search']")).size()>0)
           {
  	   try
			 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis/Search']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(analysis).build().perform();
    	   Thread.sleep(1000);
    	    WebElement modelandforecasts  = driver.findElement(By.xpath("//a[text()='Models & Forecasts']"));
    	    act.moveToElement(modelandforecasts).click().build().perform();
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Refinements']")));
  		    test.log(LogStatus.PASS," Models & Forecasts page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Models & Forecasts Analysis page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Models & Forecasts Analysis page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Models & Forecasts Analysis page not available");
			
		}
       }
        
       @Test (priority=23)
       public void verifySectorAnalysis() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Analysis/Search']")).size()>0)
           {
  	   try
			 {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis/Search']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(analysis).build().perform();
    	   Thread.sleep(1000);
    	    WebElement modelandforecasts  = driver.findElement(By.xpath("//a[text()='Sector Analysis']"));
    	    act.moveToElement(modelandforecasts).click().build().perform();
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Refine Analysis']")));
  		    test.log(LogStatus.PASS,"Sector Analysis page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Sector Analysis page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Sector Analysis page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Sector Analysis page not available");
			
		}
       }
          
       
       @Test (priority=24)
       public void verifyNews() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/News/Dashboard']")).size()>0)
           {
  	   try
			 {
    	   
    	   WebElement news = driver.findElement(By.xpath("//a[@href='/News/Dashboard']"));
    	   news.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='News']")));
  		   test.log(LogStatus.PASS,"News Page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "News Page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "News Page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "News Page not available");
			
		}
       }   
       
       @Test (priority=25)
       public void veriyconsultingService() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[text()='Services']")).size()>0)
           {
  	   try
			 {
    	  WebElement service = driver.findElement(By.xpath("//a[text()='Services']"));
    	  Actions act = new Actions(driver);
  	      act.moveToElement(service).build().perform();
  	      Thread.sleep(1000);
  	      WebElement consulting  = driver.findElement(By.xpath("//a[text()='Consulting']"));
  	      act.moveToElement(consulting).click().build().perform();
  	      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Our Expertise']")));
  		  test.log(LogStatus.PASS,"Consulting Services Homepage loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Consulting Services Page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Consulting Services Page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Consulting Services Page not available");
			
		}
       }      
     
       @Test (priority=26)
       public void veriydirectdataService() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[text()='Services']")).size()>0)
           {
  	   try
			 {
    	 WebElement service = driver.findElement(By.xpath("//a[text()='Services']"));
    	 Actions act = new Actions(driver);
  	     act.moveToElement(service).build().perform();
  	     Thread.sleep(1000);
  	     WebElement consulting  = driver.findElement(By.xpath("//a[text()='Direct Data Services']"));
  	     act.moveToElement(consulting).click().build().perform();
  	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='white medium']")));
  		 test.log(LogStatus.PASS," Direct Data Services Homepage loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Direct Data Services Page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Direct Data Services Page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Direct Data Services Page not available");
			
		}
       } 
       
       @Test (priority=27)
       public void veriyWebinar() throws InterruptedException, IOException  {
    	   if(driver.findElements(By.xpath("//a[@href='/Webinars']")).size()>0)
           {
  	   try
			 {
    	   WebElement webinar = driver.findElement(By.xpath("//a[@href='/Webinars']"));
    	   webinar.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Webinars']")));
  		   test.log(LogStatus.PASS," Webinars Page loaded successfully ");  		
			 }
	   catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "Webinars Page failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Webinars Page failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "Webinars Page not available");
			
		}
       }    
           
    @AfterMethod
	public void back () throws InterruptedException {

    	   Thread.sleep(1000); }   
   
    @AfterClass
    public void logout() throws InterruptedException{
    	   System.out.println("logout");
    	   WebElement logout = driver.findElement(By.xpath("//a[@href='/Login/Logout']"));
    	   logout.click();} 	
   
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
    		driver.get("https://login.globaldata.com/");
    		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    		driver.findElement(By.xpath("//input[@name='EmailAddress']")).sendKeys("Rajeshwar.Bhokare@globaldata.com");
    		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Shambhu@L0g!n123");
    		driver.findElement(By.xpath("//button[@class='button confine expanded']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Access your Subscriptions']")));
    		test.log(LogStatus.PASS,"login page loaded successfully");	
    	}
     

public static String capture(WebDriver driver) throws IOException 
{
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File(".//target//ExtentReports//screenshots//" + System.currentTimeMillis()+ ".png");
	String errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
    return errflpath;
}


}



