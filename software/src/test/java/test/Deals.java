	
    package test;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;

    import java.util.Date;
    import java.util.Iterator;
    import java.util.Set;

    import org.apache.commons.io.FileUtils;
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
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Deals {
		
		static WebDriver driver;
		static ExtentTest test;
		static ExtentReports report;
		static Date date=new Date();
		static SimpleDateFormat sd= new SimpleDateFormat("dd_MM_yyyy");
		String icNames;
		
		
		@BeforeClass
		public void beforeClass()throws InterruptedException, IOException
			{
				report = new ExtentReports("Verificationsof_Deals" + sd.format(date) + ".html", false);
				test = report.startTest("Verification of Deals");
				
			}
		
		@Test(priority=1)
		public void before() throws InterruptedException
		{
			Deals t= new Deals();
			t.Login();
			
		}
		
		@Test(dataProvider ="ICnames",priority=2)
		  public void Runner(String icName) throws Exception
			  {
			        Deals t2= new Deals();
				  	t2.allsite(icName);
				  	t2.verify_Deals(icName);
			  }
		
		
		@DataProvider(name="ICnames")
		 public Object[] data()
		        {
		  return new Object [] {"Technology","Foodservice","Construction","Consumer","Mining","Insurance","Retail","Disruptor","Packaging","Travel & Tourism","Aerospace, Defense & Security","Banking & Payments","Automotive","Explorer"};
		         }

		@AfterClass
		 public static void endTest()
		 {
			report.endTest(test);
		 report.flush();
		 driver.quit();
		 }
		
	         public void Login()
 	      {	
			 
		
		 		WebDriverManager.edgedriver().setup();
		 		driver=new EdgeDriver();
			 	driver.manage().window().maximize();
			 	driver.get("https://login.globaldata.com");
			 	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			 	driver.findElement(By.id("EmailAddress")).sendKeys("Rajeshwar.bhokare@globaldata.com");
			 	driver.findElement(By.id("Password")).sendKeys("Shambhu@L0g!n123");
			 	driver.findElement(By.className("button")).click();
			 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Other Products']")));  
			 	test.log(LogStatus.PASS, "Login page displayed successfully");
			 	
			 
		    }//

		public void allsite(String icName) throws InterruptedException
		{
				driver.navigate().to("https://login.globaldata.com/Hom");
				driver.findElement(By.xpath("//a[normalize-space()='"+icName+"']"));
				WebElement sitename=driver.findElement(By.xpath("//a[normalize-space()='"+icName+"']"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", sitename);
				test.log(LogStatus.INFO, icName.toUpperCase());
		}

		public static String capture(WebDriver driver) throws IOException 
		{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File Dest = new File(".//target//ExtentReports//screenshots//" + System.currentTimeMillis()+ ".png");
			String errflpath = Dest.getAbsolutePath();
			FileUtils.copyFile(scrFile, Dest);
		    return errflpath;
		}    
		

	  public void verify_Deals(String icName) throws IOException 
	  
	  {
		  
		  	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			Actions actions=new Actions(driver);
			WebElement Databases=driver.findElement(By.xpath("//div[@id='main-navigation']//descendant::a[normalize-space()='Databases']"));
			actions.moveToElement(Databases).build().perform();
			
			if(icName.equals("Banking & aPayments"))
			 {
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='menuitem']//descendant::a[normalize-space()='General']")));
				 WebElement sector= driver.findElement(By.xpath("//a[@id='sector-databases-header-label']"));
				 js.executeScript(";arguments[0].click();", sector);
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Deals'])[1]")));
				 WebElement deals= driver.findElement(By.xpath("(//a[text()='Deals'])[1]"));
				 js.executeScript(";arguments[0].click();", deals);
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='regular']")));
				 test.log(LogStatus.PASS, "City Profiles page loaded successfully");
				 
			 }
		
			 else 
			 {
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Deals'])[1]")));
				 WebElement deals= driver.findElement(By.xpath("(//a[text()='Deals'])[1]"));
				 js.executeScript(";arguments[0].click();", deals);
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='dashboard']")));
				 test.log(LogStatus.PASS, "Deals page loaded successfully");
			 }
					 this.verify_Dashboard();
					 this.verify_AllDeals();
					 this.verify_detailedpage();
					 this.verify_RelatedInvestors();
				     this.verify_RelatedAdvisors();
					 this.verify_RelatedCompanies();
					 this.verify_DisruptorDeals();
					 this.verify_Disruptivedetailepage();   
			         this.verify_Investors();
			         this.verify_investordetailepage();
			         this.verify_Advisors();
			         this.verify_Advisorsdetailepage();
			       
			   }



		public void verify_Dashboard() throws IOException 
		
			{
				WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
				JavascriptExecutor js=(JavascriptExecutor)driver;

				if(driver.findElements(By.xpath("//a[@id='dashboard']")).size()>0)
				 {
					try
				 {
							WebElement dashboard= driver.findElement(By.xpath("//a[@id='dashboard']"));
							js.executeScript(";arguments[0].click();", dashboard);
							w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
							test.log(LogStatus.PASS, "Dashboard page loaded successfully");
						
				}
				    catch(Exception co)
				{
						 test.log(LogStatus.FAIL, "Dashboard  page content failed to  load ");
						 test.log(LogStatus.INFO, co.getMessage());
						 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Dasboard page content failed to  load ");	
					}
				 }
				else
				{
					     test.log(LogStatus.PASS, "Dashboard  page not available");
					
				}

			}

		public void verify_AllDeals() throws IOException 
		
		{
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;

			if(driver.findElements(By.xpath("//a[@id='dealslisting']")).size()>0)
			 {
				try
				{
						WebElement alldeals= driver.findElement(By.xpath("//a[@id='dealslisting']"));
						js.executeScript(";arguments[0].click();", alldeals);
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Deal Results']")));
						test.log(LogStatus.PASS, "LHS Deals page loaded successfully");
					
				}
				catch(Exception co)
				{
					test.log(LogStatus.FAIL, "LHS Deals  page content failed to  load ");
					test.log(LogStatus.INFO, co.getMessage());
					test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS Deals page content failed to  load ");	
				}
			 }
			 else
			 {
				test.log(LogStatus.PASS, "LHS Deals page not available");
				
		     	  }

	           	}

        public void verify_detailedpage() throws IOException 
		
		{
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;

			if(driver.findElements(By.xpath("(//a[@target='_blank'])[2]")).size()>0)
			 {
				try
				{
						WebElement detailedpage= driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
						js.executeScript(";arguments[0].click();", detailedpage);
						
						Set<String> window = driver.getWindowHandles();
						Iterator <String> it = window.iterator();
						String parent = it.next();
						String child =it.next();
						driver.switchTo().window(child);
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='regular']")));
						test.log(LogStatus.PASS, "Deal detail page loaded successfully");
						driver.close();
						
						driver.switchTo().window(parent);
				}
					
				
				catch(Exception co)
				{
					test.log(LogStatus.FAIL, "Deal detail page  content failed to  load ");
					test.log(LogStatus.INFO, co.getMessage());
					test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Deal detail page content failed to  load ");	
				}
			 }
			else
			{
				test.log(LogStatus.PASS, "Deals detaile page not available");
				
			}

		}
        
        
          public void verify_RelatedInvestors() throws IOException 
		
		{
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;

			if(driver.findElements(By.xpath("//a[@id='rInvestors']")).size()>0)
			 {
				try
				{
						WebElement detailedpage= driver.findElement(By.xpath("//a[@id='rInvestors']"));
						js.executeScript(";arguments[0].click();", detailedpage);
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='regular']")));
						test.log(LogStatus.PASS, "Related Investors Page loaded successfully");
					
					
				}
				catch(Exception co)
				{
					test.log(LogStatus.FAIL, "Related Investors Page content failed to  load ");
					test.log(LogStatus.INFO, co.getMessage());
					test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Related Investors Page content failed to  load ");	
				}
			 }
			else
			{
				test.log(LogStatus.PASS, "Related Investors Page not available");
				
			}

		}
        

      public void verify_RelatedAdvisors() throws IOException 

      {
	    WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
	     JavascriptExecutor js=(JavascriptExecutor)driver;

	    if(driver.findElements(By.xpath("//a[@id='rAdvisors']")).size()>0)
	 {
		try
		{
				WebElement detailedpage= driver.findElement(By.xpath("//a[@id='rAdvisors']"));
				js.executeScript(";arguments[0].click();", detailedpage);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Advisors related to deal results']")));
				test.log(LogStatus.PASS, "Related Advisors Page loaded successfully");
			
			
		}
		catch(Exception co)
		{
			test.log(LogStatus.FAIL, "Related Advisors Page content failed to  load ");
			test.log(LogStatus.INFO, co.getMessage());
			test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Related Advisors Page content failed to  load ");	
		}
	 }
	   else
	 {
		test.log(LogStatus.PASS, "Related Advisors Page not available");
		
	  }

    }

      
      public void verify_RelatedCompanies() throws IOException 

    {
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
	JavascriptExecutor js=(JavascriptExecutor)driver;

	if(driver.findElements(By.xpath("//a[@id='rCompanies']")).size()>0)
	 {
		try
		{
				WebElement detailedpage= driver.findElement(By.xpath("//a[@id='rCompanies']"));
				js.executeScript(";arguments[0].click();", detailedpage);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button askExpert AskanAnalystbutton']")));
				test.log(LogStatus.PASS, "Related Companies Page loaded successfully");
			 
			
		}
		catch(Exception co)
		{
			test.log(LogStatus.FAIL, "Related Companies Page content failed to  load ");
			test.log(LogStatus.INFO, co.getMessage());
			test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Related Companies Page content failed to  load ");	
		}
	 }
	else
	{
		test.log(LogStatus.PASS, "Related Companies Page not available");
		
	 }

   }

        
	public void verify_DisruptorDeals() throws IOException 
		
		{
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;

			if(driver.findElements(By.xpath("//a[@id='DisruptiveDeals']")).size()>0)
			 {
				try
				{
						WebElement disruptorDeals= driver.findElement(By.xpath("//a[@id='DisruptiveDeals']"));
						js.executeScript(";arguments[0].click();", disruptorDeals);
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Disruptive Tech Deals']")));
						test.log(LogStatus.PASS, "Disruptor Deals page loaded successfully");
					
				}
				catch(Exception co)
				{
					test.log(LogStatus.FAIL, "Disruptor Tech Deals page content failed to  load ");
					test.log(LogStatus.INFO, co.getMessage());
					test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Disruptor Tech Deals page content failed to  load ");	
				}
			 }
			else
			{
				test.log(LogStatus.PASS, "Disruptor Tech Deals page not available");
				
			}

		}

	public void verify_Disruptivedetailepage() throws IOException 
	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//a[@id='DisruptiveDeals']")).size()>0)
		 {
			try																								
			{
					WebElement detailedpage= driver.findElement(By.xpath("(//a[@target='_blank'])[30]"));
					js.executeScript(";arguments[0].click();", detailedpage);
					
					Set<String> window = driver.getWindowHandles();
					Iterator <String> it = window.iterator();
					String parent = it.next();
					String child =it.next();
					driver.switchTo().window(child);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Download']")));
					test.log(LogStatus.PASS, "Disruptor Tech deal detail page loaded successfully");
					driver.close();
					
					driver.switchTo().window(parent);
			}
				
			
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "Disruptor Tech deal detail page  content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Disruptor deal detail page content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "Disruptor Tech deal detail page not available");
			
		}

	}
        
	public void verify_Investors() throws IOException 
	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//a[@id='aInvestors']")).size()>0)
		 {
			try
			{
					WebElement disruptorDeals= driver.findElement(By.xpath("//a[@id='aInvestors']"));
					js.executeScript(";arguments[0].click();", disruptorDeals);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Investor Listing']")));
					test.log(LogStatus.PASS, "Investors page loaded successfully");
				
			}
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "Investors page content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Investors page content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "Investors page not available");
			
		}

	}

        
public void verify_investordetailepage() throws IOException 
	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//a[@id='aInvestors']")).size()>0)
		 {
			try
			{
					WebElement detailedpage= driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
					js.executeScript(";arguments[0].click();", detailedpage);
					
					Set<String> window = driver.getWindowHandles();
					Iterator <String> it = window.iterator();
					String parent = it.next();
					String child =it.next();
					driver.switchTo().window(child);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='regular']")));
					test.log(LogStatus.PASS, "Investor deal detail page loaded successfully");
					driver.close();
					
					driver.switchTo().window(parent);
			}
				
			
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "Investor deal detail  page  content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Investor deal page content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "Investor deal detail page not available");
			
		}

	}   
        
    
	public void verify_Advisors() throws IOException 
	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//a[@id='aAdvisors']")).size()>0)
		 {
			try
			{
					WebElement disruptorDeals= driver.findElement(By.xpath("//a[@id='aAdvisors']"));
					js.executeScript(";arguments[0].click();", disruptorDeals);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Advisor Listing']")));
					test.log(LogStatus.PASS, "Advisors page loaded successfully");
				
			}
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "Advisors page content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Advisors page content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "Advisors page not available");
			
		}

	}

public void verify_Advisorsdetailepage() throws IOException 
	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//a[@id='aAdvisors']")).size()>0)
		 {
			try
			{
					WebElement detailedpage= driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
					js.executeScript(";arguments[0].click();", detailedpage);
					
					Set<String> window = driver.getWindowHandles();
					Iterator <String> it = window.iterator();
					String parent = it.next();
					String child =it.next();
					driver.switchTo().window(child);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='regular']")));
					test.log(LogStatus.PASS, "Advisors detail page loaded successfully");
					driver.close();
					
					driver.switchTo().window(parent);////
			}
				
			
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "Advisors detail  page  content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Advisors detail content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "Advisors deal detail page not available");
			
		}

	}          
        


  
		
		@Test(priority=4)
		public void closebrowser()
		{
			driver.close();
		}

	}
