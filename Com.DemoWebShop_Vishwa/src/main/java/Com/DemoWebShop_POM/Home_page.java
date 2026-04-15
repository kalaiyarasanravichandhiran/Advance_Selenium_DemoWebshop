package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
public Home_page (WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy (partialLinkText = "Log out")
	private WebElement LogoutBtn;
	
	@FindBy (partialLinkText = "Addresses")
	private WebElement addressBtn;

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}

	public WebElement getAddressBtn() {
		return addressBtn;
	}
	
}
