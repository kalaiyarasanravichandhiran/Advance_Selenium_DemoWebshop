package Com.DemoWebShop_GenericUtility;

public interface FrameWorkConstants {

	JavaUtility jutil = new JavaUtility();
	static final String excelFilepath = "./src/test/resources/Test/advance_selenium.xlsx";
	static final String propertyFilePath = "./src/test/resources/Test/commonDataN2.properties";
	static final String screenshotPath = "./screenshots/" + jutil.LocalDateTime() + ".png";
	static final String ListenersScreenshotPath = "./listenersScreenshot/" + jutil.LocalDateTime() + ".png";
	static final String reportsPath = "./reports/" + jutil.LocalDateTime() + ".html";
}
