package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address_page {

	public Address_page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy (xpath = "//input[@value='Add new']")
	private WebElement addNewBtn;

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}
}
