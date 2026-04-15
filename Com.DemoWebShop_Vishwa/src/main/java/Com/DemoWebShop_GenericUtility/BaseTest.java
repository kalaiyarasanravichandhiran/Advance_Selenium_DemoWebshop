package Com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_page;
import Com.DemoWebShop_POM.Login_page;
import Com.DemoWebShop_POM.Welcome_page;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fileutility = new FileUtility(); // object creation for fileUtility to call

	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;

	public Welcome_page welcomePage = new Welcome_page(driver);
	public Login_page loginpage = new Login_page(driver);
	public Home_page homepage = new Home_page(driver);
	
	public WebDriverUtility webDriverutility = new WebDriverUtility();

	@BeforeSuite
	public void bs() {
		System.out.println("@Beforesuit  Database connected");

	}

	@BeforeTest
	public void bt() {
		System.out.println("@BeforeTest  Reportes started");

		spark = new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Address Module");
	}

	@BeforeClass
	public void bc() throws IOException {
		System.out.println("@BeforeClass  Browser launch");

		String browser = fileutility.readDataFromPropertyFile("browserName"); // Take the browser from property file
		String url = fileutility.readDataFromPropertyFile("baseUrl"); // take the URL from property file
    // String browser = System.getProperty("browserName");  //This is parameter way passing
     //  String url = System.getProperty("baseUrl");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Enter the correct browser");
		}

		sdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

	}

	@BeforeMethod
	public void bm() throws IOException {
		System.out.println("@BeforeMethod Login");
		welcomePage = new Welcome_page(driver);
		welcomePage.getLoginBtn().click();

		loginpage = new Login_page(driver);
		loginpage.getEmailTextField().sendKeys(fileutility.readDataFromPropertyFile("emailID"));
		loginpage.getPasswordTextField().sendKeys(fileutility.readDataFromPropertyFile("password"));
	
		loginpage.getLoginBtn().click();

		homepage = new Home_page(driver);

	}

	@AfterMethod
	public void am() {
		System.out.println("@AfterMethod Logout");
		homepage.getLogoutBtn().click();
	}

	@AfterClass
	public void ac() throws InterruptedException {
		System.out.println("@AfterClass Browser closed");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void at() {
		System.out.println("@AfterTest Report ended");
	}

	@AfterSuite
	public void as() {
		System.out.println("@AfterMethod Report Ended");
	}

}
