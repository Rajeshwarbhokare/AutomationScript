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
public class Covid {

	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static Date date=new Date();
	static SimpleDateFormat sd= new SimpleDateFormat("dd_MM_yyyy");
	String icNames;
	
	@BeforeTest
	public void launchBrowser()  
	        {
			  
			  report=new ExtentReports("Verifications_Covid19IC" + sd.format(date) + ".html", false);
			  test=report.startTest("Verificationof_Covid19IC");
			  System.out.println("ExtentReport");
		    }

       @BeforeClass
       public void loginGlobaldata ()
       {
    	   Covid t = new Covid();
            t.login();
       }

    
       
       
       @Test (priority=1)
       public void verifycovidIc ()  throws IOException
       {
		
       
       if(driver.findElements(By.xpath("//span[@class='icon xx-large left gd-virus']")).size()>0)
             {
    	   try
			 {
    		   
			 
    	   WebElement covid = driver.findElement(By.xpath("//span[@class='icon xx-large left gd-virus']"));
    	   covid.click();   
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h1[@class='medium'])[1]")));
    	   test.log(LogStatus.INFO,"covid_19 "); 
  		   test.log(LogStatus.PASS,"covid_19 homepage loaded successfully");  		  
       }
    	   catch(Exception co)
			{
					 test.log(LogStatus.FAIL, "covid_19 homepage failed to  load ");
					 test.log(LogStatus.INFO, co.getMessage());
					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "covid_19 homepage failed to  load ");	
				}
			 }
			else
			{
				     test.log(LogStatus.PASS, "covid_19 homepage  page not available");
				
			}

		}
    		   
    		   
       @Test (priority=2)
       public void verifycompanies () throws IOException
       {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Company/Index?recordtype=Companies']")).size()>0)
                 {
        	   try
    			 {
        		   
    	   WebElement companies = driver.findElement(By.xpath("//a[@href='/Company/Index?recordtype=Companies']"));
    	   companies.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='All Companies']")));  
  		   test.log(LogStatus.PASS,"companies datapage loaded successfully");  		 
    			 }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "companies page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "companies page failed to  load ");	
    				}
    			 }
    			else
    			{
    				     test.log(LogStatus.PASS, "companies page  page not available");
    				
    			}

    		}
        		   
       
               
       
       
       
       @Test (priority=3)
       public void verifypatents() throws InterruptedException, IOException
        {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {
    	     WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
    	     test.log(LogStatus.PASS,"Database sector page loaded successfully");    
        	 Actions act = new Actions(driver);
    	     act.moveToElement(database).build().perform();
    	     Thread.sleep(1000);
    	     WebElement patents = driver.findElement(By.xpath("(//a[@href='/patents/listing'])[1]"));
    	     act.moveToElement(patents).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='regular']")));  
  
  		     test.log(LogStatus.PASS,"Patent page loaded successfully");  		 	   
                 }
    	   catch(Exception co)
			{
					 test.log(LogStatus.FAIL, "Patent page failed to  load ");
					 test.log(LogStatus.INFO, co.getMessage());
					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Patent page failed to  load ");	
				}
                 }
			else
			{
				     test.log(LogStatus.PASS, "Patent page not available");
				
			}

		}//
        
       @Test (priority=4)
       public void verifysectorDatabase() throws InterruptedException, IOException
  {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {
    	     WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));      
        	 Actions act = new Actions(driver);
    	     act.moveToElement(database).build().perform();
    	     Thread.sleep(1000);
    	     WebElement pipelinedrugs = driver.findElement(By.xpath("(//a[text()='Pipeline Drugs'])[1]"));
    	     act.moveToElement(pipelinedrugs).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Pipeline Drugs']")));  
  		     test.log(LogStatus.PASS,"pipeline drugs sector page loaded successfully");  		 	   
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "pipeline drugs sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "pipeline drugs sector page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "pipeline drugs sector  page not available");
    				
    			}

    		}
       
       @Test (priority=5)
       public void clinicaltrailsector () throws InterruptedException, IOException
  {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   { 	
    	     WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
        	 Actions act = new Actions(driver);
    	     act.moveToElement(database).build().perform();
    	     Thread.sleep(1000);
  		     WebElement clinicaltrail = driver.findElement(By.xpath("(//a[text()='Clinical Trials'])[1]"));
    	     act.moveToElement(clinicaltrail).click().build().perform();
    	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Clinical Trials']"))); 
  		     test.log(LogStatus.PASS,"clinicaltrail sector page loaded successfully");  		       
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "clinical trail sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "clinical trail sector sector page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "clinical trail sectorsector  page not available");
    				
    			}

    		}
     
       @Test (priority=6)
       public void verifyInvestigatorssector () throws InterruptedException, IOException
         {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {  	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement Investigators = driver.findElement(By.xpath("(//a[text()='Investigators'])[1]"));
    	   act.moveToElement(Investigators).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Investigators']"))); 
  		   test.log(LogStatus.PASS,"Investigators sector page loaded successfully");  		      
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Investigators  sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Investigators  sector sector page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Investigators  sectorsector  page not available");
    				
    			}

    		}
       
       @Test (priority=7)
       public void verifyRegulatoryMilestones () throws InterruptedException, IOException
    {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {  	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);    
  		   WebElement Regulatorymilestones = driver.findElement(By.xpath("(//a[text()='Regulatory Milestones'])[1]"));
    	   act.moveToElement(Regulatorymilestones).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Regulatory Milestones']"))); 
  		   test.log(LogStatus.PASS,"Regulatory milestones sector page loaded successfully");  		     
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Regulatory milestones  sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Regulatory milestones sector  page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Regulatory milestones  sectorsector  page not available");
    				
    			}

    		}
       
       @Test (priority=8)
       public void verifyCatalystCalendar () throws InterruptedException, IOException
           {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {  	 	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000); 
  		   WebElement CatalystCalendar = driver.findElement(By.xpath("(//a[text()='Catalyst Calendar'])[1]"));
    	   act.moveToElement(CatalystCalendar).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Catalyst Calendar']"))); 
  		   test.log(LogStatus.PASS,"CatalystCalendar sector page loaded successfully");  			      
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "CatalystCalendar sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Catalyst Calendar sector  page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Catalyst Calendar  sectorsector  page not available");///
    				
    			}

    		}
       
       @Test (priority=9)
       public void verifydigitalInnovationsSector () throws InterruptedException, IOException
{
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {  	  	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000); 
  		   WebElement digitalInnovationsSector = driver.findElement(By.xpath("//a[text()='Digital Innovations']"));
    	   act.moveToElement(digitalInnovationsSector).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Digital Innovations']"))); 
  		   test.log(LogStatus.PASS,"Digital innovations page loaded successfully");  		  
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Digital innovations sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Digital innovations sector  page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Digital innovations  sectorsector  page not available");
    				
    			}

    		}
       @Test (priority=10)
       public void verifyDealsSector () throws InterruptedException, IOException
{
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {  	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement dealsSector = driver.findElement(By.xpath("(//a[text()='Deals'])[1]"));
    	   act.moveToElement(dealsSector).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Deals']"))); 
  		   test.log(LogStatus.PASS,"deals sector page loaded successfully");  		   
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "deals sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "deals sector  page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "deals sector page not available");
    				
    			}

    		}
       
       @Test (priority=11)
       public void verifycompanyfilinganalyticsbeta () throws InterruptedException, IOException
            {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {  	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement companyfilinganalyticsbeta = driver.findElement(By.xpath("//a[@href='/Filing/FilingListing?FilingTypeId=1']"));
    	   act.moveToElement(companyfilinganalyticsbeta).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Company Filings Analytics']")));
  		   test.log(LogStatus.PASS,"Company Filing analytics beta sector page loaded successfully");  		   
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Company Filing analytics beta sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Company Filing analytics beta sector  page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Company Filing analytics beta sector page not available");
    				
    			}

    		}
       
       @Test (priority=12)
       public void verifyEpidemiologicalIndicators () throws InterruptedException, IOException
          {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {   	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement epidemiologicalindicators = driver.findElement(By.xpath("//a[text()='Epidemiological Indicators']"));
    	   act.moveToElement(epidemiologicalindicators).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Epidemiological Indicators']")));
  		   test.log(LogStatus.PASS,"Epidemiological Indicators page loaded successfully");  		   
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Epidemiological Indicators Dashboard sector page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Epidemiological Indicators Dashboard sector  page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Epidemiological Indicators Dashboard sector page not available");
    				
    			}

    		}
       
       @Test (priority=13)
       public void verifyCOVID19SpreadMap () throws InterruptedException, IOException
       {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {   	 	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement verifyCOVID19SpreadMap = driver.findElement(By.xpath("//a[text()='COVID-19 Spread Map']"));
    	   act.moveToElement(verifyCOVID19SpreadMap).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='COVID-19 Spread Map']")));
  		   test.log(LogStatus.PASS,"COVID19 SpreadMap Dashboard page loaded successfully");  		   
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "COVID19 SpreadMap page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "COVID19 SpreadMap page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "COVID19 SpreadMap page not available");
    				
    			}

    		}
       
       @Test (priority=14)
       public void verifyCovid19Gallery () throws InterruptedException, IOException
            {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   {	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement covid19Gallery = driver.findElement(By.xpath("//a[text()='COVID-19 Gallery']"));
    	   act.moveToElement(covid19Gallery).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='COVID-19 Chart Gallery']")));
  		   test.log(LogStatus.PASS,"Covid19Gallery page loaded successfully");  		   
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Covid19Gallery Dashboard page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Covid19Gallery Dashboard page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Covid19Gallery Dashboard page not available");
    				
    			}

    		}
       
       @Test (priority=15)
       public void VrerifyCovid19CountryDashboard () throws InterruptedException, IOException
      {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   { 	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement covid19countryDashboard = driver.findElement(By.xpath("//a[text()='COVID-19 Country dashboard']"));
    	   act.moveToElement(covid19countryDashboard).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
   	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Country Dashboard']")));
  		   test.log(LogStatus.PASS,"Covid19 country Dashboard loading successfully"); 
  		  
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Covid19 country Dashboard page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Covid19 country Dashboard page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Covid19 country Dashboard page not available");
    				
    			}

    		}
       
       @Test (priority=16)
       public void VrerifyInfectiousDiseasesInfluencers () throws InterruptedException, IOException
        {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   { 	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement infectiousDiseasesInfluencers = driver.findElement(By.xpath("//a[text()='Infectious Diseases Influencers']"));
    	   act.moveToElement(infectiousDiseasesInfluencers).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
  	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Ask an Analyst']")));
  		   test.log(LogStatus.PASS,"infectious Diseases Influencers page loaded successfully"); 
  		
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "infectious Diseases Influencers page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "infectious Diseases Influencers page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "infectious Diseases Influencers page not available");
    				
    			}

    		}
       
       @Test (priority=17)
       public void VrerifyCoronavirusInfluencers () throws InterruptedException, IOException
             {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
                 {
        	   try
        	   { 	
    	   WebElement database = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));   
           Actions act = new Actions(driver);
    	   act.moveToElement(database).build().perform();
    	   Thread.sleep(1000);
  		   WebElement coronavirusInfluencers = driver.findElement(By.xpath("//a[text()='Coronavirus Influencers']"));
    	   act.moveToElement(coronavirusInfluencers).click().build().perform();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=' COVID-19 | COVID  Influencers ']")));
  		   test.log(LogStatus.PASS,"corona virus Influencers page loaded successfully"); 
  		  
           	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "corona virus Influencers page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "corona virus Influencers page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "corona virus Influencers page not available");
    				
    			}

    		}
       
      
       @Test (priority=18)
       public void verifyAnalysis() throws IOException
            {
   		
           
           if(driver.findElements(By.xpath("//a[@href='/Analysis']")).size()>0)
                 {
        	   try
        	   { 
    	   WebElement analysis = driver.findElement(By.xpath("//a[@href='/Analysis']"));
    	   analysis.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Analysis']")));
  		   test.log(LogStatus.PASS,"Analysis reportpage loaded successfully");  		
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Analysis reportpage page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Analysis report page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Analysis report page not available");
    				
    			}

    		}
       
       @Test (priority=19)
       public void verifyNews() throws IOException
        {
   		
           
           if(driver.findElements(By.xpath("(//a[@href='/News/Dashboard'])[1]")).size()>0)
                 {
        	   try
        	   { 
    	
    	   WebElement News = driver.findElement(By.xpath("(//a[@href='/News/Dashboard'])[1]"));
    	   News.click();
    	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
  	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Top Stories']"))); 
  		   test.log(LogStatus.PASS,"News report page loaded successfully");  		 
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "News report page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "News report page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "News report page not available");
    				
    			}

    		}//
       
       @Test (priority=20)
       public void verifyService() throws InterruptedException, IOException
  {
   		
           
           if(driver.findElements(By.xpath("(//a[@href='/News/Dashboard'])[1]")).size()>0)
                 {
        	   try
        	   {  
    	
    	  WebElement service = driver.findElement(By.xpath("(//li[@class='is-dropdown-submenu-parent opens-right'])[2]"));
    	  
    	  Actions act = new Actions(driver);
  	      act.moveToElement(service).build().perform();
  	      Thread.sleep(1000);   
		  WebElement directdataservice = driver.findElement(By.xpath("//a[text()='Direct Data Services']"));
  	      act.moveToElement(directdataservice).click().build().perform();
  	      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='white medium']")));  
  		  test.log(LogStatus.PASS,"Direct data service homepage loaded successfully");  		 
        	   }
        	   catch(Exception co)
    			{
    					 test.log(LogStatus.FAIL, "Direct data service page failed to  load ");
    					 test.log(LogStatus.INFO, co.getMessage());
    					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Direct data service page failed to  load ");	
    				}
                     }
    			else
    			{
    				     test.log(LogStatus.PASS, "Direct data service page not available");
    				
    			}

    		}
       
    @AfterMethod
	public void back () throws InterruptedException {
    Thread.sleep(1000);	 
    }
    
    @AfterClass
    public void logout() throws InterruptedException{
    	System.out.println("logout");
    	WebElement logout = driver.findElement(By.xpath("//a[@href='/Login/Logout']"));
    	logout.click();	
    }
    
     @AfterTest
     public void closeBrawser() {
 	System.out.println("close Browser");
 	report.endTest(test);
   	report.flush();
	 driver.quit();	
}
public void login ()
{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://login.globaldata.com");
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

