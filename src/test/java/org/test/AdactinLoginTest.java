package org.test;

import java.io.IOException;

import org.base.LibGlobal;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pages.AdactinLoginPage;
import org.pages.FBLoginPage;

public class AdactinLoginTest extends LibGlobal {
	static String excelLoc = "C:\\Users\\umapa\\Desktop\\Frameworks\\JunitFrameWork\\Excel\\Login Credentials.xlsx";

	@BeforeClass
	public static void AdactinBrowserLaunch() {
		launch_Opera_Browser();

	}

	@AfterClass
	public static void AdactinQuitBrowser() {
		quit_Broswer();

	}

	// @Before
	// public void FBBrowserLaunch() {
	// launch_Chrome_Browser();
	//
	// }
	//
	// @After
	// public void FBQuitBrowser() {
	// quit_Broswer();
	//
	// }

	@Test
	public void loginAdactin() throws IOException {
		get_Url("http://adactinhotelapp.com/index.php");
		Assert.assertTrue("Verifying the correct URL has launched",
				get_CurrentUrl().equals("http://adactinhotelapp.com/index.php"));

		AdactinLoginPage fb = new AdactinLoginPage();
		WebElement adactinUserName = fb.getTxtUserName();
		send_Keys(adactinUserName, getData(1, 0, "Adactin Login", excelLoc));
		Assert.assertEquals("Verifying the User Name", getData(1, 0, "Adactin Login", excelLoc), get_Attribute(adactinUserName));

		WebElement adactinPassword = fb.getTxtPassword();
		send_Keys(adactinPassword, getData(1, 1, "Adactin Login", excelLoc));
		Assert.assertEquals("Verifying the Password", getData(1, 1, "Adactin Login", excelLoc), get_Attribute(adactinPassword));

		WebElement adactinbtnLogin = fb.getBtnLogin();
		btn_click(adactinbtnLogin);

		explicit_WebDriver_Wait("http://adactinhotelapp.com/SearchHotel.php");
		Assert.assertTrue("user Logged on Successfully",
				get_CurrentUrl().equals("http://adactinhotelapp.com/SearchHotel.php"));

	}

	@Test
	public void loginAdactin1() throws IOException {
		get_Url("http://adactinhotelapp.com/index.php");
		AdactinLoginPage fb = new AdactinLoginPage();
		WebElement adactinUserName = fb.getTxtUserName();
		send_Keys(adactinUserName, getData(2, 0, "Adactin Login", excelLoc));
		Assert.assertEquals("Verifying the User Name", getData(1, 0, "Adactin Login", excelLoc), get_Attribute(adactinUserName));

		WebElement adactinPassword = fb.getTxtPassword();
		send_Keys(adactinPassword, getData(2, 1, "Adactin Login", excelLoc));
		Assert.assertEquals("Verifying the Password", getData(1, 1, "Adactin Login", excelLoc), get_Attribute(adactinPassword));

		WebElement adactinbtnLogin = fb.getBtnLogin();
		btn_click(adactinbtnLogin);

	}

	@Ignore
	@Test
	public void loginAdactin2() throws IOException {
		get_Url("http://adactinhotelapp.com/index.php");
		AdactinLoginPage fb = new AdactinLoginPage();
		WebElement adactinUserName = fb.getTxtUserName();
		send_Keys(adactinUserName, getData(2, 0, "Adactin Login", excelLoc));
		Assert.assertEquals("Verifying the User Name", getData(1, 0, "Adactin Login", excelLoc), get_Attribute(adactinUserName));

		WebElement adactinPassword = fb.getTxtPassword();
		send_Keys(adactinPassword, getData(2, 1, "Adactin Login", excelLoc));
		Assert.assertEquals("Verifying the Password", getData(1, 1, "Adactin Login", excelLoc), get_Attribute(adactinPassword));

		WebElement adactinbtnLogin = fb.getBtnLogin();
		btn_click(adactinbtnLogin);

	}

}
