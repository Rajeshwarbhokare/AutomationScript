package test;



	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
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

	public class cic_Tenders {
		
		static WebDriver driver;
		static ExtentReports report;
		static ExtentTest test;
		static Date date=new Date();
		static SimpleDateFormat sd= new SimpleDateFormat("dd_MM_yyyy");
		@BeforeClass
		public static void startTest()
		  {
			report = new ExtentReports("VerificationOfTenders" + sd.format(date) + ".html", false);
			//ExtentReports er = new ExtentReports("ChineLinksSomokeTest" + sd.format(date) + ".html", false);
		    test = report.startTest("Verification of Tenders");
		    
		  }	
		
		@Test(priority=1)
		public void before() throws InterruptedException
		  {
			cic_Tenders t1= new cic_Tenders();
			t1.Login();
		 }
		  
		@Test(dataProvider ="ICnames",priority=2)
		public void Runner(String icName) throws Exception
		  {
			cic_Tenders t2= new cic_Tenders();
			   t2.sitename(icName);
			   t2.Verify_tendersDatabase();
		  }
		
		 public static String capture(WebDriver driver) throws IOException 
		  {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File Dest = new File(".//target//ExtentReports//screenshots//" + System.currentTimeMillis()+ ".png");
			String errflpath = Dest.getAbsolutePath();
			FileUtils.copyFile(scrFile, Dest);
			return errflpath;
		 }
		
		
		@DataProvider(name="ICnames")
		public Object[] data()
		     {
		 return new Object [] {"Construction"};
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
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();	
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.get("https://login.globaldata.com/Home");
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				driver.findElement(By.id("EmailAddress")).sendKeys("Rajeshwar.bhokare@globaldata.com");
				driver.findElement(By.id("Password")).sendKeys("Shambhu@L0g!n123");
				driver.findElement(By.className("button")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Other Intelligence Centers']")));  
				test.log(LogStatus.PASS, "OneLogin HomePage displayed successfully");
		   }
		
		public void sitename(String icName) throws InterruptedException 
		   {
				//System.out.print(icName);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.navigate().to("https://login.globaldata.com/Home");
				driver.findElement(By.xpath("//a[normalize-space()='"+icName+"']"));
				WebElement sitename=driver.findElement(By.xpath("//a[normalize-space()='"+icName+"']"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", sitename);
				test.log(LogStatus.INFO, icName.toUpperCase());
		   }	
		
		public void Verify_tendersDatabase() throws Exception 
		   { 	
			
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(150));
				Actions actions=new Actions(driver);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				WebElement databases=	driver.findElement(By.xpath("//div[@id='main-navigation']//descendant::a[normalize-space()='Databases']"));
				actions.moveToElement(databases).build().perform();
				WebElement tenders=driver.findElement(By.xpath("//*[@role='menuitem']/a[contains(text(),'Tenders Database')]"));//click on United States of America
				js.executeScript(";arguments[0].click();", tenders);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='status'])[1]")));  
				test.log(LogStatus.PASS,"Tenders page loaded successfully");
		
		
				this.Verify_client_view();
				this.Verify_vendor_view();
				this.Verify_market_view();
				this.Verify_charts();
				this.Verify_tenderContacts();
				
				
		
		}


	public void Verify_client_view() throws Exception 
	   { 
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			try
			{
				if(driver.findElements(By.xpath("//*[contains(text(),'Client View')]")).size()>0)
				{
					WebElement clientview=driver.findElement(By.xpath("//*[contains(text(),'Client View')]"));
					js.executeScript(";arguments[0].click();", clientview);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='status'])[1]")));  
					test.log(LogStatus.PASS,"client_view page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"client_view is not Available");
				}
			}
			catch(Exception cv)
			{
				test.log(LogStatus.FAIL, "client_view page not loaded");
				test.log(LogStatus.INFO, cv.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "client_view page not loaded");
				
			}
	   }

	public void Verify_vendor_view() throws Exception 
		{ 
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			try
			{
				if(driver.findElements(By.xpath("//*[contains(text(),'Vendor View')]")).size()>0)
				{
					WebElement vendor_view=driver.findElement(By.xpath("//*[contains(text(),'Vendor View')]"));
					js.executeScript(";arguments[0].click();", vendor_view);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='status'])[1]")));  
					test.log(LogStatus.PASS,"vendor_view page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"vendor_view is not Available");
				}
			}
			catch(Exception vv)
			{
				test.log(LogStatus.FAIL, "vendor_view page not loaded");
				test.log(LogStatus.INFO, vv.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "vendor_view page not loaded");
			}
		}
	public void Verify_market_view() throws Exception 
		{ 
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			try
			{
				if(driver.findElements(By.xpath("//*[contains(text(),'Market View')]")).size()>0)
				{
					WebElement market_view=driver.findElement(By.xpath("//*[contains(text(),'Market View')]"));
					js.executeScript(";arguments[0].click();", market_view);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='status'])[1]")));  
					test.log(LogStatus.PASS,"market_view page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"market_view is not Available");
				}
			}
			catch(Exception mv)
			{
				test.log(LogStatus.FAIL, "market_view page not loaded");
				test.log(LogStatus.INFO, mv.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "market_view page not loaded");
			}
		}
	public void Verify_charts() throws Exception 
		{ 
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			try
			{
				if(driver.findElements(By.xpath("(//*[contains(text(),'Charts')])[1]")).size()>0)
				{
					WebElement charts=driver.findElement(By.xpath("(//*[contains(text(),'Charts')])[1]"));
					js.executeScript(";arguments[0].click();", charts);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='status'])[1]")));  
					test.log(LogStatus.PASS,"charts page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"charts is not Available");
				}
			}
			catch(Exception c)
			{
				test.log(LogStatus.FAIL, "charts page not loaded");
				test.log(LogStatus.INFO, c.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "charts page not loaded");
			}
		}

	public void Verify_tenderContacts() throws Exception 
		{ 
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			try
			{
				if(driver.findElements(By.xpath("(//*[contains(text(),'Tender Contacts')])[1]")).size()>0)
				{
					WebElement tenderContacts=driver.findElement(By.xpath("(//*[contains(text(),'Tender Contacts')])[1]"));
					js.executeScript(";arguments[0].click();", tenderContacts);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='status'])[1]")));  
					test.log(LogStatus.PASS,"tender Contacts page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL,"tender Contacts is not Available");
				}
			}
			catch(Exception tc)
			{
				test.log(LogStatus.FAIL, "tender Contacts page not loaded");
				test.log(LogStatus.INFO, tc.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "tender Contacts page not loaded");
			}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*
			 * WebElement marketview=driver.findElement(By.
			 * xpath("(//*[contains(text(),'Tender Contacts')])[1]"));
			 * js.executeScript(";arguments[0].click();", marketview);
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "(//div[@role='status'])[1]")));
			 * test.log(LogStatus.PASS,"TenderContacts page loaded successfully");
			 */
		}


	}




