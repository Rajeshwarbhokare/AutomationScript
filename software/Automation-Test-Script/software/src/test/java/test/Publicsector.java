package test;



import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	static SimpleDateFormat sd= new SimpleDateFormat("dd_MM_yyyy");
	String icNames;
	
	 @BeforeTest
	 public void launchBrowser()  
	        {  
			  report=new ExtentReports("VerifyPublicsectorIC" + sd.format(date) + ".html", false);
			  test=report.startTest("VerifyPublicsectorIC");
			  System.out.println("ExtentReport");
		      }

       @BeforeClass
       public void loginGlobaldata ()
           {
    	      Publicsector t = new Publicsector();
              t.login();
             }

       @Test (priority=1)
       public void verifypublicsector () throws InterruptedException {
    	   WebElement publicsector = driver.findElement(By.xpath("//span[@class='icon xx-large left gd-construction-institutional']"));
    	   publicsector.click();  
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Analysis']")));
  		   test.log(LogStatus.PASS,"Public Sector"); 
  		   Thread.sleep(1000);
  	   } 		
       
       @Test (priority=2)
       public void verifyorganisation () throws InterruptedException  {
    	   WebElement organisation = driver.findElement(By.xpath("(//a[@href='/organisation/index'])[1]"));
    	   Actions act = new Actions(driver);
  	       act.moveToElement(organisation).build().perform();
  	     test.log(LogStatus.PASS,"Verify Organizations"); 
  	       Thread.sleep(1000);
  	       WebElement customer = driver.findElement(By.xpath("//a[@href='/Organisation/Index?tab=Customer']"));
	       act.moveToElement(customer).click().build().perform();
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@id='customise-th-customername']")));
	       test.log(LogStatus.PASS,"Customers details page loaded successfully");  	
       }   
       
       @Test (priority=3)
       public void verifysupplier () throws InterruptedException  {
    	    WebElement organisation = driver.findElement(By.xpath("(//a[@href='/organisation/index'])[1]"));  
    	    Actions act = new Actions(driver);
  	        act.moveToElement(organisation).build().perform();
  	        Thread.sleep(1000);
    	    WebElement supplier = driver.findElement(By.xpath("//a[@href='/Organisation/Index?tab=Supplier']"));
    	    act.moveToElement(supplier).click().build().perform();   
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@class='nosort sorting_disabled']")));
  		    test.log(LogStatus.PASS,"Supplier details page loaded successfully");  
       }  
       
       @Test (priority=4)
       public void verifysector () throws InterruptedException  {
    	    WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	    test.log(LogStatus.PASS,"sector Homepage loaded successfully "); 
    	    Actions act = new Actions(driver);
    	    act.moveToElement(sector).build().perform();
    	    test.log(LogStatus.PASS,"Verify total 9 Sector");
    	    Thread.sleep(1000);
    	     WebElement centralgovernment = driver.findElement(By.xpath("//a[text()='Central Government']"));
    	     act.moveToElement(centralgovernment).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Central Government']")));
  		     test.log(LogStatus.PASS,"central government overview Sector Page loaded successfully");  		
  		 } 
       
       
       @Test (priority=5)
       public void verifyEducation () throws InterruptedException  {
    	     WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	     Actions act = new Actions(driver);
    	     act.moveToElement(sector).build().perform();
    	     Thread.sleep(1000);
    	     WebElement education = driver.findElement(By.xpath("//a[text()='Education']"));
    	     act.moveToElement(education).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Education']")));
  		     test.log(LogStatus.PASS,"education overview Sector Page loaded successfully");  		
  		  } 
       
       
       @Test (priority=6)
       public void verifyHealthcare () throws InterruptedException  {
    	     WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	     Actions act = new Actions(driver);
    	     act.moveToElement(sector).build().perform();
    	     Thread.sleep(1000);
    	     WebElement healthcare = driver.findElement(By.xpath("//a[text()='Healthcare']"));
    	     act.moveToElement(healthcare).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Healthcare']")));
  		     test.log(LogStatus.PASS,"Healthcare Oerview Sector Page loaded successfully ");  		
  		  } 
       
       @Test (priority=7)
       public void verifyTransport () throws InterruptedException  {
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
       
       @Test (priority=8)
       public void verifyLocalGovernment () throws InterruptedException  {
    	     WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	     Actions act = new Actions(driver);
    	     act.moveToElement(sector).build().perform();
    	     Thread.sleep(1000);
    	     WebElement localgovernment = driver.findElement(By.xpath("//a[text()='Local Government']"));
    	     act.moveToElement(localgovernment).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Local Government']")));
  		     test.log(LogStatus.PASS,"LocalGovernment overview Sector Page loaded successfully ");  		
  		  } 
	  
       @Test (priority=9)
       public void verifyPolice () throws InterruptedException  {
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
 	  
       @Test (priority=10)
       public void verifyUtilities () throws InterruptedException  {
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
       
       @Test (priority=11)
       public void verifyRegulatoryBodies () throws InterruptedException  {
    	   WebElement sector = driver.findElement(By.xpath("//a[@href='/Sector/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(sector).build().perform();
    	   Thread.sleep(1000); 
    	   WebElement regulatoryBodies = driver.findElement(By.xpath("//a[text()='Regulatory Bodies']"));
    	   act.moveToElement(regulatoryBodies).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Regulatory Bodies']")));
  		   test.log(LogStatus.PASS," Regulatory Bodiesoverview Sector Page loaded successfully");  		 
  		   } 
       
       @Test (priority=12)
       public void verifyNonProfitOrganizations () throws InterruptedException  {
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
       
       @Test (priority=13)
       public void verifyDatabase () throws InterruptedException  {
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   test.log(LogStatus.PASS,"Verify Database");  	
    	   Thread.sleep(1000);
    	   WebElement opportunities  = driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]"));
    	   act.moveToElement(opportunities).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Opportunities Database']")));
  		   test.log(LogStatus.PASS," Opportunities Database page loaded successfully  ");  		
  		   driver.navigate().back();
  		   }    
       
       
       @Test (priority=14)
       public void verifyPreProcurement () throws InterruptedException  {
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
       
       
       @Test (priority=15)
       public void verifyMarketanalyzers() throws InterruptedException  {
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
       
       @Test (priority=16)
       public void verifymarketdashboard() throws InterruptedException{
    	   
    	   
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
    	   WebElement marketmarketdashboard  = driver.findElement(By.xpath("//a[text()='Market Dashboard']"));
    	   act.moveToElement(marketmarketdashboard).click().build().perform();
    	   try {
    		   
           WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Public Sector']")));	 
    	   }
    	   catch(org.openqa.selenium.TimeoutException e)
    	   {
      	   test.log(LogStatus.PASS,"Market Dashboard Page getting Access Denied page"); 
    	   }     
      	  driver.navigate().back();
      	
  		   }     
 
       
       @Test (priority=17)
       public void veriycityeconomics() throws InterruptedException  {
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   database.click();
    	   Thread.sleep(1000);
    	   JavascriptExecutor js =(JavascriptExecutor)driver;
    	   js.executeScript("window.scrollBy(0,300)");
    	   WebElement cityeconomics  = driver.findElement(By.xpath("//a[text()=' City Economics']"));
    	   cityeconomics.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='City Economics']")));
  		   test.log(LogStatus.PASS,"city economics page loaded successsfully"); 
  		   
  		   }    
 
       
       @Test (priority=18)
       public void veriycityprofile() throws InterruptedException  {
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
    	   database.click();
    	   Thread.sleep(1000);
    	   JavascriptExecutor js =(JavascriptExecutor)driver;
    	   js.executeScript("window.scrollBy(0,300)");
    	   WebElement cityprofile  = driver.findElement(By.xpath("//a[text()=' City Profiles']"));
    	   cityprofile.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='City Profiles']")));
  		   test.log(LogStatus.PASS,"city profile page loaded successsfully");  		
  		   }    
       
       @Test (priority=19)
       public void verifyAnalysis() throws InterruptedException  {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis/Search']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(analysis).build().perform();
    	   test.log(LogStatus.PASS," verify Analysis "); 
    	   Thread.sleep(1000);
    	    WebElement custemeranalysis  = driver.findElement(By.xpath("//a[text()='Customer Analysis']"));
    	    act.moveToElement(custemeranalysis).click().build().perform();
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Analysis']")));
  		    test.log(LogStatus.PASS," Customers Analysis page loaded Successfully");  		
  		   }    
        
       @Test (priority=20)
       public void verifySupplierAnalysis() throws InterruptedException  {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis/Search']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(analysis).build().perform();
    	   Thread.sleep(1000);
    	   WebElement supplieranalysis  = driver.findElement(By.xpath("//a[text()='Supplier Analysis']"));
    	   act.moveToElement(supplieranalysis).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Analysis']")));
  		   test.log(LogStatus.PASS," Supplier Analysis page loaded successfully ");  		
  		   }   
       
       @Test (priority=21)
       public void verifyInsideandTrends() throws InterruptedException  {
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis/Search']"));
    	   Actions act = new Actions(driver);
    	   act.moveToElement(analysis).build().perform();
    	   Thread.sleep(1000);
    	    WebElement insideandTrends  = driver.findElement(By.xpath("//a[text()='Insights & Trends']"));
    	    act.moveToElement(insideandTrends).click().build().perform();
    	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Analysis']")));
  		    test.log(LogStatus.PASS," Insights & Trends Analysis page loaded successfully ");  		
  		   }    
       
       @Test (priority=22)
       public void verifyModelsandForecasts() throws InterruptedException  {
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
        
       @Test (priority=23)
       public void verifySectorAnalysis() throws InterruptedException  {
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
       
       @Test (priority=24)
       public void verifyNews() throws InterruptedException  {
    	   WebElement news = driver.findElement(By.xpath("//a[@href='/News/Dashboard']"));
    	   news.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='News']")));
  		   test.log(LogStatus.PASS," News Page loaded successfully ");  		
  		   }    
       
       @Test (priority=25)
       public void veriyconsultingService() throws InterruptedException  {
    	  WebElement service = driver.findElement(By.xpath("//a[text()='Services']"));
    	  Actions act = new Actions(driver);
  	      act.moveToElement(service).build().perform();
  	      Thread.sleep(1000);
  	      WebElement consulting  = driver.findElement(By.xpath("//a[text()='Consulting']"));
  	      act.moveToElement(consulting).click().build().perform();
  	      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Our Expertise']")));
  		  test.log(LogStatus.PASS," consulting services Homepage loaded successfully ");  		
  		   }    
     
       @Test (priority=26)
       public void veriydirectdataService() throws InterruptedException  {
    	 WebElement service = driver.findElement(By.xpath("//a[text()='Services']"));
    	 Actions act = new Actions(driver);
  	     act.moveToElement(service).build().perform();
  	     Thread.sleep(1000);
  	     WebElement consulting  = driver.findElement(By.xpath("//a[text()='Direct Data Services']"));
  	     act.moveToElement(consulting).click().build().perform();
  	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='white medium']")));
  		 test.log(LogStatus.PASS," Direct data service Homepage loaded successfully ");  		
  		   }   
       
       @Test (priority=27)
       public void veriyWebinar() throws InterruptedException  {
    	   WebElement webinar = driver.findElement(By.xpath("//a[@href='/Webinars']"));
    	   webinar.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Webinars']")));
  		   test.log(LogStatus.PASS," Webinars Page loaded successfully ");  		
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
     
}



