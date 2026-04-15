package Com.DemoWebShop_GenericUtility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	public void webpageScreenshot(WebDriver driver) throws IOException {  //Take full page ScreenShot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenshotPath);
		FileHandler.copy(temp, dest);

	}

	public void webElementScreenshot(WebElement element) throws IOException {  //TakeScreenShot as particular element
		File temp = element.getScreenshotAs(OutputType.FILE); 
		File dest = new File(FrameWorkConstants.screenshotPath);
		FileHandler.copy(temp, dest);

	}

	public void javascriptScrollToElement(WebDriver driver, WebElement element) {  //Scroll till the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void javascriptClick(WebDriver driver, WebElement element) {  //Click the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click();", element);
	}

	public void selectByVisibleText(WebElement element, String text) {   //Used to select by text value
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void alertpopupAccept(WebDriver driver) {  //accept the pop up
		driver.switchTo().alert().accept();
	}

}
