package Marketline;

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

public class Databases {
	
	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static Date date=new Date();
	static SimpleDateFormat sd= new SimpleDateFormat("dd_MM_yyyy");
	String icNames;
	
	@BeforeClass
	public void beforeClass()throws InterruptedException, IOException
		{
			report = new ExtentReports("Verificationsof_Ad_Ml_Databases" + sd.format(date) + ".html", false);
			test = report.startTest("VerificationsOf_ML_Databases");	
		}
	
	@Test(priority=1)
	public void before() throws InterruptedException
	{
		Databases t= new Databases();
		t.Login();	
	}
	
	@Test(dataProvider ="ICnames",priority=2)
	  public void Runner(String icName) throws Exception
		  {
		Databases t2= new Databases();
		        
			  	t2.allsector(icName);
			  	t2.verify_companies(icName);
			  	t2.verify_Deals(icName);
			  	t2.verify_sectorNews(icName);
		  }
	
	@DataProvider(name="ICnames")
	 public Object[] data()
	        {
	  return new Object [] {"Aerospace & Defense","Agriculture & Forestry","Automotive","Business & Consumer Services","Chemicals","Construction & Real Estate","Consumer Goods","Financial Services","Government & Non-Profit Organisations","Media & Digital Entertainment","Industrial Goods & Machinery","Energy & Utilities","Media & Digital Entertainment","Metals & Mining","Paper & Packaging","Pharmaceuticals & Healthcare","Retail, Wholesale & Foodservice","Telecoms & IT","Tourism, Leisure & Hospitality","Transportation, Infrastructure & Logistics"};
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
			 	driver.get("https://advantage.marketline.com");
			 	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			 	driver.findElement(By.id("loginDetails_UserName")).sendKeys("Rajeshwar.bhokare@globaldata.com");
			 	driver.findElement(By.id("loginDetails_Password")).sendKeys("Shambhu@L0g!n123");
			 	driver.findElement(By.id("loginSubmit")).click();
			 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='GlobalData Intelligence Centers']")));  
			 	test.log(LogStatus.PASS, "Marketline HomePage displayed successfully");			 				 	
	    }

	public void allsector(String icName) throws InterruptedException
	{
			driver.navigate().to("https://advantage.marketline.com/HomePage/Home");
			WebElement allsector=driver.findElement(By.xpath("//strong[text()='Browse by Sector']"));
			allsector.click();
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
	

  public void verify_companies(String icName) throws IOException   
  {  
	  	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View all Companies']")));
		 WebElement companies= driver.findElement(By.xpath("//a[text()='View all Companies']"));
		 js.executeScript(";arguments[0].click();", companies);
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Companies']")));
				 
				 this.verify_listallcompanies();
				 this.verify_overviewpage();
				 this.verify_financials();
		         this.verify_News();
		         this.verify_newsdetailedpage();
		         this.verify_peers();
		         this.verify_peersdetailedpage();
		         this.verify_researchreports();
		         this.verify_researchreportdetailedpage();
		         this.verify_deals();
		         this.verify_companydealsdetailedpage();
		         this.verify_swotanalysis();		        
		   }
  
	public void verify_listallcompanies() throws IOException 	
		{
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;

			if(driver.findElements(By.xpath("//span[text()='List All Companies']")).size()>0)
			 {
				try
			 {
						WebElement listallcompanies= driver.findElement(By.xpath("//span[text()='List All Companies']"));
						js.executeScript(";arguments[0].click();", listallcompanies);
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Companies']")));
						test.log(LogStatus.INFO, "Verify companies sector wise");
						test.log(LogStatus.PASS, "List All companies page loaded successfully");
					
			}
			    catch(Exception co)
			{
					 test.log(LogStatus.FAIL, "List All companies  page content failed to  load ");
					 test.log(LogStatus.INFO, co.getMessage());
					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "List All companies page content failed to  load ");	
				}
			 }
			else
			{
				     test.log(LogStatus.PASS, "List All companies  page not available");
				
			}
		}
	public void verify_overviewpage() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//a[text()='Walmart Inc']")).size()>0) //(//td[@data-title='Company Name'])[1]
		 {
			try
		 {
					WebElement overview= driver.findElement(By.xpath("//a[text()='Walmart Inc']"));
					js.executeScript(";arguments[0].click();", overview);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "Companies Overviews page loaded successfully");
				
		}
		    catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "companies Overviews page content failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "companies Overviews page content failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "companies Overviews page not available");
			
		}

	}
	
       public void verify_financials() throws IOException   { 	
	
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("(//a[@class='showSingle showNav not-active'])[2]")).size()>0)
		 {
			try
		 {
					WebElement financials= driver.findElement(By.xpath("(//a[@class='showSingle showNav not-active'])[2]"));
					js.executeScript(";arguments[0].click();", financials);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "LHS Financials page loaded successfully");
					driver.navigate().back();		
		}
		    catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "LHS Financials page content failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS Financials  page content failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "LHS Financials page not available");
			
		}
	}

	public void verify_News() throws IOException 
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("(//a[@class='showSingle showNav not-active'])[3]")).size()>0)
		 {
			try
		 {
					WebElement news= driver.findElement(By.xpath("(//a[@class='showSingle showNav not-active'])[3]"));
					js.executeScript(";arguments[0].click();", news);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "LHS News page loaded successfully");							
		}
		    catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "LHS News page content failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS News  page content failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "LHS News  page not available");			
		}
	}

	 public void verify_newsdetailedpage() throws IOException 	
		{
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;

			if(driver.findElements(By.xpath("(//a[@class='showSingle showNav not-active'])[3]")).size()>0)
			 {
				try
				{
						WebElement newsdetailedpage= driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
						js.executeScript(";arguments[0].click();", newsdetailedpage);
						
						Set<String> window = driver.getWindowHandles();
						Iterator <String> it = window.iterator();
						String parent = it.next();
						String child =it.next();
						driver.switchTo().window(child);
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@class='lead']")));
						test.log(LogStatus.PASS, "News detail page loaded successfully");
						driver.close();						
						driver.switchTo().window(parent);
						driver.navigate().back();
				}									
				catch(Exception co)
				{
					test.log(LogStatus.FAIL, "News detail page  content failed to  load ");
					test.log(LogStatus.INFO, co.getMessage());
					test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "News detail page content failed to  load ");	
				}
			 }
			else
			{
				test.log(LogStatus.PASS, "News detail page not available");				
			}
		}       	

	public void verify_peers() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("(//a[@class='showSingle showNav not-active'])[4]")).size()>0)
		 {
			try
		 {
					WebElement peers= driver.findElement(By.xpath("(//a[@class='showSingle showNav not-active'])[4]"));
					js.executeScript(";arguments[0].click();", peers);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "LHS Peers page loaded successfully");
					
				
		}
		    catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "LHS Peers page content failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS Peers  page content failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "LHS Peers page not available");
			
		}
	}

	 public void verify_peersdetailedpage() throws IOException 	
		{
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;

			if(driver.findElements(By.xpath("(//a[@class='showSingle showNav not-active'])[4]")).size()>0)
			 {
				try
				{
						WebElement newsdetailedpage= driver.findElement(By.xpath("//tr[@id='103913']"));
						js.executeScript(";arguments[0].click();", newsdetailedpage);
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@class='lead']")));
						test.log(LogStatus.PASS, "Peers detail page loaded successfully");						
						driver.navigate().back();
				}
									
				catch(Exception co)
				{
					test.log(LogStatus.FAIL, "Peers detail page  content failed to  load ");
					test.log(LogStatus.INFO, co.getMessage());
					test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Peers detail page content failed to  load ");	
				}
			 }
			else
			{
				test.log(LogStatus.PASS, "Peers detail page not available");				
			}
		}
  
	public void verify_researchreports() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("(//a[@class='showSingle showNav not-active'])[5]")).size()>0)
		 {
			try
		 {
					WebElement researchreports= driver.findElement(By.xpath("(//a[@class='showSingle showNav not-active'])[5]"));
					js.executeScript(";arguments[0].click();", researchreports);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "LHS Research Report page loaded successfully");									
		}
		    catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "LHS Research Report page content failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS Research Report  page content failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "LHS Research Report page not available");			
		}
	}
	
	public void verify_researchreportdetailedpage() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("(//a[@class='showSingle showNav not-active'])[5]")).size()>0)
		 {
			try
			{
					WebElement researchdetailedpage= driver.findElement(By.xpath("(//td[@style='white-space:normal; overflow:hidden'])[1]"));
					js.executeScript(";arguments[0].click();", researchdetailedpage);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@class='lead']")));
					test.log(LogStatus.PASS, "Research Report detail page loaded successfully");
					driver.navigate().back();				
			}				
			
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "Research Report detail page  content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Research Report detail page content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "Research Report deatail page not available");			
		}
	}
	
	public void verify_deals() throws IOException 
	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("(//a[@class='showSingle showNav not-active'])[6]")).size()>0)
		 {
			try
		 {
					WebElement deals= driver.findElement(By.xpath("(//a[@class='showSingle showNav not-active'])[6]"));
					js.executeScript(";arguments[0].click();", deals);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "LHS Deals page loaded successfully");					
				
		}
		    catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "LHS deals page content failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS deals  page content failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "LHS deals page not available");
			
		}
	}	
	
public void verify_companydealsdetailedpage() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("(//td[@data-title='Headline'])[1]")).size()>0)
		 {
			try
			{
					WebElement dealsdetailedpage= driver.findElement(By.xpath("(//td[@data-title='Headline'])[1]"));
					js.executeScript(";arguments[0].click();", dealsdetailedpage);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@class='lead']")));
					test.log(LogStatus.PASS, "Deals detail page loaded successfully");				
					driver.navigate().back();
			}
						
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "deals detail page  content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "deals detail page content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "deals detail page not available");			
		}
	}

public void verify_swotanalysis() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//span[text()='SWOT Analysis']")).size()>0)
		 {
			try
		 {
					WebElement swotanalysis= driver.findElement(By.xpath("//span[text()='SWOT Analysis']"));
					js.executeScript(";arguments[0].click();", swotanalysis);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Summary']")));
					test.log(LogStatus.PASS, "LHS SWOT Analysis page loaded successfully");			
		}
		    catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "LHS SWOT Analysis page content failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS SWOT Analysis  page content failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "LHS SWOT Analysis page not available");			
		}     	
	}

//For deals       
          
public void verify_Deals(String icName) throws IOException, InterruptedException 

{	   	
	  	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		allsector(icName);
			
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View all Deals']")));
		 WebElement deals= driver.findElement(By.xpath("//a[text()='View all Deals']"));
		 js.executeScript(";arguments[0].click();", deals);
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='dashboard']")));
		 test.log(LogStatus.INFO, "Verify Deals sector wise");
		 test.log(LogStatus.PASS, "View all Deals page loaded successfully");
		 
				 this.verify_Dashboard();
				 this.verify_Deals();
				 this.verify_dealsdetailedpage();
				 this.verify_RelatedInvestors();
		         this.verify_RelatedAdvisors();
		         this.verify_RelatedCompanies();
		         this.verify_Investors();
		         this.verify_investordetailepage();
		         this.verify_advisors();
		         this.verify_advisorsdetailepage();         
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
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Deals']")));
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

	public void verify_Deals() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//a[@id='dealslisting']")).size()>0)
		 {
			try
		 {
					WebElement dashboard= driver.findElement(By.xpath("//a[@id='dealslisting']"));
					js.executeScript(";arguments[0].click();", dashboard);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "LHS Deals page loaded successfully");				
		}
		    catch(Exception co)
		{
				 test.log(LogStatus.FAIL, "LHS deals  page content failed to  load ");
				 test.log(LogStatus.INFO, co.getMessage());
				 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS Deals page content failed to  load ");	
			}
		 }
		else
		{
			     test.log(LogStatus.PASS, "LHS Deals page not available");			
		}
	}

	 public void verify_dealsdetailedpage() throws IOException 		
		{
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js=(JavascriptExecutor)driver;

			if(driver.findElements(By.xpath("(//a[@target='_blank'])[1]")).size()>0)
			 {
				try
				{
						WebElement detailedpage= driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
						js.executeScript(";arguments[0].click();", detailedpage);
						
						Set<String> window = driver.getWindowHandles();
						Iterator <String> it = window.iterator();
						String parent = it.next();
						String child =it.next();
						driver.switchTo().window(child);
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='titlebar']")));
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
				test.log(LogStatus.PASS, "detailedpage not available");				
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
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='icon gd-icon-retail-banking'])[2]")));
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
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='icon gd-icon-expert-insight-analysis'])[2]")));
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
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='fa fa-building-o']")));
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
 
   public void verify_Investors() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//span[text()='Investors']")).size()>0)
		 {
			try
			{
					WebElement disruptorDeals= driver.findElement(By.xpath("//span[text()='Investors']"));
					js.executeScript(";arguments[0].click();", disruptorDeals);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "LHS Investors page loaded successfully");				
			}
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "LHS Investors page content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS Investors page content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "LHS Investors page not available");			
		}
	}
     
   public void verify_investordetailepage() throws IOException 	
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//a[@href='/Deals/Investors']")).size()>0)
		 {
			try
			{
					WebElement detailedpage= driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
					js.executeScript(";arguments[0].click();", detailedpage);
					
					Set<String> window = driver.getWindowHandles();
					Iterator <String> it = window.iterator();
					String parent = it.next();
					String child =it.next();
					driver.switchTo().window(child);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@class='lead']")));
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

   public void verify_advisors() throws IOException 
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		if(driver.findElements(By.xpath("//span[text()='Advisors']")).size()>0)
		 {
			try
			{
					WebElement disruptorDeals= driver.findElement(By.xpath("//span[text()='Advisors']"));
					js.executeScript(";arguments[0].click();", disruptorDeals);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='subtitle']")));
					test.log(LogStatus.PASS, "LHS Advisors page loaded successfully");			
			}
			catch(Exception co)
			{
				test.log(LogStatus.FAIL, "LHS Advisors page content failed to  load ");
				test.log(LogStatus.INFO, co.getMessage());
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "LHS Advisors page content failed to  load ");	
			}
		 }
		else
		{
			test.log(LogStatus.PASS, "LHS Advisors page not available");
			
		}
	}

    public void verify_advisorsdetailepage() throws IOException 
   {
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(60));
	JavascriptExecutor js=(JavascriptExecutor)driver;

	if(driver.findElements(By.xpath("//span[text()='Advisors']")).size()>0)
	 {
		try
		{
				WebElement advisorsdetailepage= driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
				js.executeScript(";arguments[0].click();", advisorsdetailepage);
				
				Set<String> window = driver.getWindowHandles();
				Iterator <String> it = window.iterator();
				String parent = it.next();
				String child =it.next();
				driver.switchTo().window(child);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@class='lead']")));
				test.log(LogStatus.PASS, "Advisors deal detail page loaded successfully");
				driver.close();				
				driver.switchTo().window(parent);
		}		
		
		catch(Exception co)
		{
			test.log(LogStatus.FAIL, "Advisors deal detail  page  content failed to  load ");
			test.log(LogStatus.INFO, co.getMessage());
			test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Advisors deal page content failed to  load ");	
		}
	 }
	else
	{
		test.log(LogStatus.PASS, "Advisors deal detail page not available");		
	  }
  }   

     //News

   public void verify_sectorNews(String icName) throws Exception 
   {

	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	allsector(icName);
	
	 if(driver.findElements(By.xpath("//*[contains(text(),'View all News')]")).size()>0)
	 {
		 WebElement viewallNews= driver.findElement(By.xpath("//*[contains(text(),'View all News')]"));
			js.executeScript(";arguments[0].click();", viewallNews);
			
			 try
			 {
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='lead']")));
				 test.log(LogStatus.INFO, "Verify News");
				 test.log(LogStatus.PASS, "News page loaded successfully");
			 }
			 catch(Exception News)

			 {
				 test.log(LogStatus.FAIL, "News page failed to load");
			 }
			 this.Verify_NewsDashboard();
			 this.Verify_LHSNews();
			 this.Verify_opnions();
			 this.Verify_Analytics();
	 }
	 else
	 {
		 test.log(LogStatus.FAIL, "News not available");
	 }	 
}

   public void Verify_NewsDashboard() throws Exception 
   {
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 if(driver.findElements(By.xpath("//*[@id='dashboard']")).size()>0)
	 {
		 WebElement dashboard= driver.findElement(By.xpath("//*[@id='dashboard']"));
			js.executeScript(";arguments[0].click();", dashboard);
			 try
			 {
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='spanoverview']")));
				 WebElement dd= driver.findElement(By.xpath("//*[@class='block']/h3"));
				 js.executeScript(";arguments[0].click();", dd);
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='lead']")));
				 driver.navigate().back();
				 test.log(LogStatus.PASS, "News dashboard detailed page loaded successfully");
			 }
			 catch(Exception News)

			 {
				 test.log(LogStatus.FAIL, "News dashboard page failed to load");
			 }
  }
 	 else
	 {
		 test.log(LogStatus.PASS, "News dashboard not available");
	 }
  }

    public void Verify_LHSNews() throws Exception 
    {
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
	JavascriptExecutor js=(JavascriptExecutor)driver;

	 if(driver.findElements(By.xpath("//*[@id='newslisting']")).size()>0)
	 {
		 WebElement lhsnews= driver.findElement(By.xpath("//*[@id='newslisting']"));
			js.executeScript(";arguments[0].click();", lhsnews);
		 
			try
			 {
				 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='spanoverview']/h2")));
				 String count=driver.findElement(By.xpath("(//*[@class='total'])[2]")).getText(); 
				 String[] counts=count.split("of"); 
				 String[] Ncount=counts[1].split(" "); 
				 String NewsCounts=Ncount[1].replace(",", "");    
				 int techvendor=Integer.parseInt(NewsCounts); System.out.println(techvendor);
				 test.log(LogStatus.INFO,"Total News:"+NewsCounts);
				
				 WebElement newsdetailed= driver.findElement(By.xpath("(//*[@id='reportsTable']/tbody/tr/td/a)[1]"));
					js.executeScript(";arguments[0].click();", newsdetailed);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='lead']")));
					driver.navigate().back();
					test.log(LogStatus.PASS, "Lhs News  detailed page loaded successfully");
			 }
			 catch(Exception ND)
			 {
				 test.log(LogStatus.FAIL, " Lhs News detailed page failed to load");
			 }
	 }
	 else
	 {
		 test.log(LogStatus.PASS, " Lhs News  not available");
	 }
}

public void Verify_opnions() throws Exception 
{
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
	JavascriptExecutor js=(JavascriptExecutor)driver;

	if(driver.findElements(By.xpath("//*[contains(text(),'Opinions and Features')]")).size()>0)
	 {
		WebElement opnions= driver.findElement(By.xpath("//*[contains(text(),'Opinions and Features')]"));
		js.executeScript(";arguments[0].click();", opnions);

		 try
		 {
			 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='spanoverview']/h2")));
			 String count=driver.findElement(By.xpath("(//*[@class='total'])[2]")).getText(); 
			 String[] counts=count.split("of"); 
			 String[] Ncount=counts[1].split(" "); 
			 String opnionCounts=Ncount[1].replace(",", "");    
			 int techvendor=Integer.parseInt(opnionCounts); System.out.println(techvendor);
			 test.log(LogStatus.INFO,"Total Opinion and Features:"+opnionCounts);
			
			 WebElement opniondetailed= driver.findElement(By.xpath("(//*[@id='reportsTable']/tbody/tr/td/a)[1]"));
				js.executeScript(";arguments[0].click();", opniondetailed);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='lead']")));
				driver.navigate().back();
				test.log(LogStatus.PASS, "Opinions & Features detailed page loaded successfully");
		 }
		 catch(Exception News)

		 {
			 test.log(LogStatus.FAIL, "News dashboard page failed to load");
		 }
	 }
	 else
	 {
		 test.log(LogStatus.PASS, " Opinions & Features  not available");
	 }
}

public void Verify_Analytics() throws Exception 
{
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	if(driver.findElements(By.xpath("//*[@id='analytics']")).size()>0)
	 {
		WebElement analytics= driver.findElement(By.xpath("//*[@id='analytics']"));
		js.executeScript(";arguments[0].click();", analytics);

		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='spanoverview']/h2")));
		 String Analytics1 =driver.findElement(By.xpath("//*[@id='analytics']")).getText(); 
		 String Analytics=driver.findElement(By.xpath("//*[@class='subtitle']")).getText();
		 if( Analytics1.equalsIgnoreCase(Analytics))  
			{
			 test.log(LogStatus.PASS, Analytics +   "page  displayed successfully");
			}
		 else
			{
			 test.log(LogStatus.FAIL, Analytics1 +" page failed to load");
			}
	 }
	 else
	 {
		 test.log(LogStatus.PASS, " Analytics  not available");
	 }
	driver.navigate().to("https://advantage.marketline.com/");
	 WebElement ml=driver.findElement(By.xpath("(//*[@href='/HomePage/Home'])[2]"));
	    js.executeScript("arguments[0].click();", ml);
}

    //INDUSTRY
    @Test (priority=3)
    public void verify_industryprofile () throws InterruptedException, IOException {
	     
	       if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
	             {
	    	   try
				 {
	   WebElement databases = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
	   Actions act = new Actions(driver);
       act.moveToElement(databases).build().perform();
          
     WebElement Industry = driver.findElement(By.xpath("//a[text()='Industry']"));
     act.moveToElement(Industry).click().build().perform();
     test.log(LogStatus.INFO,"Verify Industry");
    
    WebElement Industrystatistics = driver.findElement(By.xpath("//a[text()='Industry Statistics']"));
    act.moveToElement(Industrystatistics).click().build().perform();
    Thread.sleep(5000);
    
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Industry Statistics']")));
    test.log(LogStatus.PASS,"Industry Statistics Home Page loaded successfully");  	
		 }
    catch(Exception co)
	{
			 test.log(LogStatus.FAIL, "Industry Statistics Home page failed to  load ");
			 test.log(LogStatus.INFO, co.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Industry Statistics Home page failed to  load ");	
		}
	 }
	else
	{
		     test.log(LogStatus.PASS, "Industry Statistics Home page  not available");		
	}
}   

   @Test (priority=4)
    public void verify_valuesdashboard () throws InterruptedException, IOException {
	       driver.switchTo().frame(0);
	       if(driver.findElements(By.xpath("//span[@id='tableauTabbedNavigation_tab_1']")).size()>0)
	             {
	    	   try
				 { 
	    		      
    WebElement valuesdashboard = driver.findElement(By.xpath("//span[@id='tableauTabbedNavigation_tab_1']"));
    valuesdashboard.click();
    Thread.sleep(8000);  
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Marketline Industry Statistics Dashboard']")));
    test.log(LogStatus.PASS,"Values Dashboard page loaded successfully"); 
		 }
    catch(Exception co)
   	{
			 test.log(LogStatus.FAIL, "Values Dashboard  page failed to  load ");
			 test.log(LogStatus.INFO, co.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Values Dashboard  page failed to  load ");	
		}
	 }
	else
	{
		     test.log(LogStatus.PASS, "Values Dashboard  page  not available");		
	}
   } 

      @Test (priority=5)
      public void verify_Volumedashboard() throws InterruptedException, IOException {
	     
	       if(driver.findElements(By.xpath("//span[@id='tableauTabbedNavigation_tab_2']")).size()>0)
	             {
	    	   try
				 { 
	    		     
    WebElement Volumedashboard = driver.findElement(By.xpath("//span[@id='tableauTabbedNavigation_tab_2']"));
    Volumedashboard.click();
    Thread.sleep(3000); 
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Volume Time Series           ']")));
    test.log(LogStatus.PASS,"Volumes Dashboard page loaded successfully");    
		 }
    catch(Exception co)
	{
			 test.log(LogStatus.FAIL, "Volumes Dashboard  page failed to  load ");
			 test.log(LogStatus.INFO, co.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Volumes Dashboard page failed to  load ");	
		}
	 }
	else
	   {
		     test.log(LogStatus.PASS, "Volumes Dashboard page  not available");		
	  }
  } 

     @Test (priority=6)
     public void verify_Segmentationdashboard() throws InterruptedException, IOException {
	     
	       if(driver.findElements(By.xpath("//span[@id='tableauTabbedNavigation_tab_3']")).size()>0)
	             {
	    	   try
				 { 
    WebElement Segmentationdashboard = driver.findElement(By.xpath("//span[@id='tableauTabbedNavigation_tab_3']"));
    Segmentationdashboard.click();
    Thread.sleep(3000);  
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Whole Market Segmentation']")));
    test.log(LogStatus.PASS,"Segmentation dashboard page loaded successfully"); 
    driver.switchTo().defaultContent();
		 }
    catch(Exception co)
	{
			 test.log(LogStatus.FAIL, "Segmentation dashboard page failed to  load ");
			 test.log(LogStatus.INFO, co.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Segmentation dashboard  page failed to  load ");	
		}
	 }
	else
	{
		     test.log(LogStatus.PASS, "Segmentation dashboard page  not available");	
	}
} 

       @Test (priority=7)
       public void verify_industrydata() throws InterruptedException, IOException {
	     
	       if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
	             {
	    	   try
				 {
	   WebElement databases = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
	   Actions act = new Actions(driver);
       act.moveToElement(databases).build().perform();
    
       WebElement Industry = driver.findElement(By.xpath("//a[text()='Industry']"));
       act.moveToElement(Industry).click().build().perform();
       WebElement industrydata = driver.findElement(By.xpath("//a[text()='industry data']"));
       act.moveToElement(industrydata).click().build().perform();
       Thread.sleep(3000);
   
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Industry Data'])[1]")));
      test.log(LogStatus.PASS,"industry data Page loaded successfully");  	
		 }
    catch(Exception co)
	     {
			 test.log(LogStatus.FAIL, "industry data page failed to  load ");
			 test.log(LogStatus.INFO, co.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "industry data page failed to  load ");	
		}
	 }
	else
	{
		     test.log(LogStatus.PASS, "industry data page  not available");
		
	  }
    }   

     @Test (priority=8)
     public void verify_consumerdataanalytics() throws InterruptedException, IOException {
	     
	       if(driver.findElements(By.xpath("//a[@href='/Databases/Index']")).size()>0)
	             {
	    	   try
				 {
	   WebElement databases = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
	   Actions act = new Actions(driver);
       act.moveToElement(databases).build().perform();
      
       WebElement Industry = driver.findElement(By.xpath("//a[text()='Industry']"));
       act.moveToElement(Industry).click().build().perform();
  
       WebElement consumerdataanalytics = driver.findElement(By.xpath("//a[text()='Consumer Data Analytics']"));
       act.moveToElement(consumerdataanalytics).click().build().perform();
       Thread.sleep(3000);
    
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Consumer Data Analytics']")));
      test.log(LogStatus.PASS,"Consumer Data Analytics Page loaded successfully");  	
		 }
catch(Exception co)
	{
			 test.log(LogStatus.FAIL, "Consumer Data Analytics page failed to  load ");
			 test.log(LogStatus.INFO, co.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Consumer Data Analytics page failed to  load ");	
		}
	 }
	else
	{
		     test.log(LogStatus.PASS, "Consumer Data Analytics page  not available");		
	}
}  

//COUNTRIES AND CITIES

    @Test (priority=9)
    public void verify_Countrystatistics () throws InterruptedException, IOException {
	     
	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
	             {
	    	   try
				 {
	   WebElement databases = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
	   Actions act = new Actions(driver);
       act.moveToElement(databases).build().perform(); 
      WebElement countriesandcities = driver.findElement(By.xpath("(//a[text()='Countries & Cities'])[1]"));
      act.moveToElement(countriesandcities).click().build().perform();
      test.log(LogStatus.INFO,"Verify Countries & Cities");
    
      WebElement Countrystatistics = driver.findElement(By.xpath("//a[text()='Country Statistics']"));
      act.moveToElement(Countrystatistics).click().build().perform();
   
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Country Statistics']")));
      test.log(LogStatus.PASS,"Country Statistics Home Page loaded successfully");  	
		 }
     catch(Exception co)
     	{
			 test.log(LogStatus.FAIL, "Country Statistics Home page failed to  load ");
			 test.log(LogStatus.INFO, co.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Country Statistics Home page failed to  load ");	
		}
	 }
     	else
	 {
		     test.log(LogStatus.PASS, "Country Statistics Home page  not available");		
     	}
     }   

    @Test (priority=10)
     public void verify_Citystatistics () throws InterruptedException, IOException {
	     
	       if(driver.findElements(By.xpath("//a[@id='Analysismenu']")).size()>0)
	             {
	    	   try
				 {
	   WebElement databases = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
	   Actions act = new Actions(driver);
      act.moveToElement(databases).build().perform();    
      WebElement countriesandcities = driver.findElement(By.xpath("(//a[text()='Countries & Cities'])[1]"));
      act.moveToElement(countriesandcities).click().build().perform();
      WebElement Citystatistics = driver.findElement(By.xpath("//a[text()='City Statistics']"));
      act.moveToElement(Citystatistics).click().build().perform();
    
     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='City Statistics']")));
     test.log(LogStatus.PASS,"City Statistics Home Page loaded successfully");  
     driver.switchTo().defaultContent();  
		 }
    catch(Exception co)
	    {
			 test.log(LogStatus.FAIL, "City Statistics Home page failed to  load ");
			 test.log(LogStatus.INFO, co.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "City Statistics Home page failed to  load ");	
		}
	 }
	else
	{
		     test.log(LogStatus.PASS, "City Statistics Home page  not available");		
     	}       
     }   
   
    @Test (priority=11)
     public void company_prospector() throws InterruptedException, IOException {     
	 WebElement databases = driver.findElement(By.xpath("//a[@href='/Databases/Index']"));
	 Actions act = new Actions(driver);
     act.moveToElement(databases).build().perform();	
     WebElement companyprospector = driver.findElement(By.xpath("//a[text()='Company Prospector']"));
     act.moveToElement(companyprospector).click().build().perform();
     Thread.sleep(3000);
     
     WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(100));
 	JavascriptExecutor js=(JavascriptExecutor)driver;
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Company Prospector')])[2]")));
	//WebElement cp=driver.findElement(By.xpath("(//*[contains(text(),'Company Prospector')])[2]"));
	//js.executeScript("arguments[0].click();", cp);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='maincontent']/div/div/h2")));
	test.log(LogStatus.PASS,"Company Prospector overview page loaded");
	Thread.sleep(3000);
	WebElement quick=driver.findElement(By.xpath("//*[@id='column_other']//descendant::a[contains(text(),'Quick search options')]"));
	js.executeScript("arguments[0].click();", quick);
	Thread.sleep(3000);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='tickboxes']/div/table/tbody/tr/td/div/div/div)[1]")));
	Thread.sleep(3000);
	WebElement ma=driver.findElement(By.xpath("(//div[@class='tickboxes']/div/table/tbody/tr/td/div/div/div)[1]"));
	js.executeScript("arguments[0].click();", ma);
	Thread.sleep(3000);
	WebElement industry=driver.findElement(By.xpath("//*[@id='column_other']//descendant::a[contains(text(),'Industry')]"));
	js.executeScript("arguments[0].click();", industry);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='checkbox'])[33]")));
	driver.findElement(By.xpath("(//*[@type='checkbox'])[33]")).click();
	test.log(LogStatus.PASS,"Selected Chemicals in Industry");
	Thread.sleep(3000);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='checkbox'])[39]")));
	driver.findElement(By.xpath("(//*[@type='checkbox'])[39]")).click();
	test.log(LogStatus.PASS,"Selected Financial Services in Industry");
	Thread.sleep(3000);
	WebElement geography=driver.findElement(By.xpath("//*[@id='column_other']//descendant::a[contains(text(),'Geography')]"));
	js.executeScript("arguments[0].click();", geography);
	test.log(LogStatus.PASS,"Selected United States in geography");
	Thread.sleep(3000);
	WebElement country=driver.findElement(By.xpath("(//*[@type='checkbox'])[17]"));
	js.executeScript("arguments[0].click();", country);
	Thread.sleep(3000);
	WebElement viewresults=driver.findElement(By.xpath("(//a[contains(text(),'View Results')])[2]"));
	js.executeScript("arguments[0].click();", viewresults);
	Thread.sleep(3000);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='tdCName'])")));
	String company1 =driver.findElement(By.xpath("(//*[@id='tdCName'])[1]/a")).getText();
	Thread.sleep(3000);
	WebElement company=driver.findElement(By.xpath("(//*[@id='tdCName'])[1]/a"));
	js.executeScript("arguments[0].click();", company);
	Thread.sleep(3000);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='productname']")));
	 String company2=driver.findElement(By.xpath("//*[@class='productname']")).getText();
	Thread.sleep(3000);
	
	 if( company1.equalsIgnoreCase(company2))  		 
		{
		 test.log(LogStatus.PASS,"Company Prospector  detailed page  loaded successfully");
		}
	 else
		{
		 test.log(LogStatus.FAIL,"Company Prospector page  failed to  load");		 
		}		
     }
    
    @Test (priority=12)

    public void company_reportgenerator() throws InterruptedException, IOException 
	{
	
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(100));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement databases=driver.findElement(By.xpath("(//*[contains(text(),'Databases')])"));
		js.executeScript("arguments[0].click();", databases);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Company Report Generator')])[2]")));
		WebElement crg=driver.findElement(By.xpath("(//*[contains(text(),'Company Report Generator')])[2]"));
		js.executeScript("arguments[0].click();", crg);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='maincontent']/div/div/h2/span")));
		test.log(LogStatus.PASS,"Company Report Generator overview page loaded");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='formstyle2']")).sendKeys("ibm");
		driver.findElement(By.xpath("(//*[@class='button_right']/a)[2]")).click();
		test.log(LogStatus.PASS,"Entered 'IBM' in search box");
		Thread.sleep(10000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='caclsInline']")));
		driver.findElement(By.xpath("(//*[@valign='top']/input)[1]")).click();
		driver.findElement(By.xpath("(//*[@class='button_right']/a)[3]")).click();
		String MainWindow=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		while(i1.hasNext())
		{
			String childWindow=i1.next();
			if(!MainWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				
					driver.manage().window().maximize();
					driver.findElement(By.xpath("//*[@class='button_right']/a")).click();
					test.log(LogStatus.PASS,"Report is generated for IBM");
					test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Report for IBM is generated");	
					
					Thread.sleep(3000);
					driver.switchTo().window(MainWindow);								
						}
					}
			}
	
	@Test(priority=14)
	public void closebrowser()
	{
		driver.close();
	  }
   }