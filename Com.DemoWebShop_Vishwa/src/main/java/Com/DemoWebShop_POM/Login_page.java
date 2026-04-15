package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	public Login_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement EmailTextField;

	@FindBy(id = "Password")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//input[@class='button-1 login-button']")
	private WebElement LoginBtn;

	public WebElement getEmailTextField() {
		return EmailTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

}
