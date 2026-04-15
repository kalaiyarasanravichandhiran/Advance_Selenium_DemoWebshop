package Com.DemoWebshop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Add_new_address_page;
import Com.DemoWebShop_POM.Address_page;

public class TC_001_Verify_User_is_able_to_add_address_or_not_Test extends BaseTest {

	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		webDriverutility.javascriptScrollToElement(driver, homepage.getAddressBtn());
		homepage.getAddressBtn().click();

		Address_page addressPage = new Address_page(driver);
		webDriverutility.javascriptScrollToElement(driver, addressPage.getAddNewBtn());
		addressPage.getAddNewBtn().click();

		Add_new_address_page addNewAddress = new Add_new_address_page(driver);
		addNewAddress.getFirstNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 0));
		addNewAddress.getLastNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 1));
		addNewAddress.getEmailTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 2));

		webDriverutility.selectByVisibleText(addNewAddress.getCountryDropDown(),
				fileutility.readDataFromExcelFile("Sheet1", 1, 3));
		// addNewAddress.getCountryDropDown().sendKeys(fileutility.readDataFromExcelFile("Sheet1",
		// 1, 3));
		addNewAddress.getCityTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 4));
		addNewAddress.getAddress1TextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 5));
		addNewAddress.getZipPostalCodeTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 6));
		addNewAddress.getPhoneNumberTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 7));
		addNewAddress.getSaveBtn().click();

		Thread.sleep(2000);
		webDriverutility.webpageScreenshot(driver);

	}

}
