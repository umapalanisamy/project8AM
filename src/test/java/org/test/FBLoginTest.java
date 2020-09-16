package org.test;

import java.io.IOException;

import org.base.LibGlobal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pages.FBLoginPage;

public class FBLoginTest extends LibGlobal {

	static String excelLoc = "C:\\Users\\umapa\\Desktop\\Frameworks\\JunitFrameWork\\Excel\\Login Credentials.xlsx";

	@BeforeClass
	public static void FBBrowserLaunch() {
		launch_Chrome_Browser();

	}

	@AfterClass
	public static void FBQuitBrowser() {
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
	public void loginFB1() throws IOException {
		get_Url("https://www.facebook.com/");
		Assert.assertTrue("Verifying the correct URL has launched",
				get_CurrentUrl().equals("https://www.facebook.com/"));

		FBLoginPage fb = new FBLoginPage();
		WebElement FbUserName = fb.getTxtUserName();
		send_Keys(FbUserName, getData(1, 0, "FB Login", excelLoc));
		Assert.assertEquals("User name entered Correctly", getData(1, 0, "FB Login", excelLoc), get_Attribute(FbUserName));

		WebElement FbPassword = fb.getTxtPassword();
		send_Keys(FbPassword, getData(1, 1, "FB Login", excelLoc));
		Assert.assertEquals("Verifying the Password", getData(1, 1, "FB Login", excelLoc), get_Attribute(FbPassword));

		WebElement FbbtnLogin = fb.getBtnLogin();
		btn_click(FbbtnLogin);

		explicit_WebDriver_Wait("https://www.facebook.com/login/");
		Assert.assertTrue("Attempted Login", get_CurrentUrl().equals("https://www.facebook.com/login/"));
	}

	@Test
	public void loginFB2() throws IOException {
		get_Url("https://www.facebook.com/");
		FBLoginPage fb = new FBLoginPage();
		WebElement FbUserName = fb.getTxtUserName();
		send_Keys(FbUserName, getData(2, 0, "FB Login", excelLoc));
		Assert.assertEquals("User name entered Correctly", getData(1, 0, "FB Login", excelLoc), get_Attribute(FbUserName));
		
		WebElement FbPassword = fb.getTxtPassword();
		send_Keys(FbPassword, getData(2, 1, "FB Login", excelLoc));
		Assert.assertEquals("Verifying the Password", getData(1, 1, "FB Login", excelLoc), get_Attribute(FbPassword));

		WebElement FbbtnLogin = fb.getBtnLogin();
		btn_click(FbbtnLogin);

	}

	@Ignore
	@Test
	public void loginFB0() throws IOException {
		get_Url("https://www.facebook.com/");
		FBLoginPage fb = new FBLoginPage();
		WebElement FbUserName = fb.getTxtUserName();
		send_Keys(FbUserName, getData(2, 0, "FB Login", excelLoc));
		Assert.assertEquals("User name entered Correctly", getData(1, 0, "FB Login", excelLoc), get_Attribute(FbUserName));

		WebElement FbPassword = fb.getTxtPassword();
		send_Keys(FbPassword, getData(2, 1, "FB Login", excelLoc));
		Assert.assertEquals("Verifying the Password", getData(1, 1, "FB Login", excelLoc), get_Attribute(FbPassword));

		WebElement FbbtnLogin = fb.getBtnLogin();
		btn_click(FbbtnLogin);

	}
	
	@Test
	public void loginFB3() throws IOException {
		get_Url("https://www.facebook.com/");
		FBLoginPage fb = new FBLoginPage();
		WebElement FbUserName = fb.getTxtUserName();
		send_Keys(FbUserName, getData(3, 0, "FB Login", excelLoc));
		Assert.assertEquals("User name entered Correctly", getData(1, 0, "FB Login", excelLoc), get_Attribute(FbUserName));

		WebElement FbPassword = fb.getTxtPassword();
		send_Keys(FbPassword, getData(3, 1, "FB Login", excelLoc));
		Assert.assertEquals("Verifying the Password", getData(1, 1, "FB Login", excelLoc), get_Attribute(FbPassword));

		WebElement FbbtnLogin = fb.getBtnLogin();
		btn_click(FbbtnLogin);

	}
	
	@Test
	public void loginFB4() throws IOException {
		get_Url("https://www.facebook.com/");
		FBLoginPage fb = new FBLoginPage();
		WebElement FbUserName = fb.getTxtUserName();
		send_Keys(FbUserName, getData(4, 0, "FB Login", excelLoc));
		Assert.assertEquals("User name entered Correctly", getData(1, 0, "FB Login", excelLoc), get_Attribute(FbUserName));

		WebElement FbPassword = fb.getTxtPassword();
		send_Keys(FbPassword, getData(4, 1, "FB Login", excelLoc));
		Assert.assertEquals("Verifying the Password", getData(1, 1, "FB Login", excelLoc), get_Attribute(FbPassword));

		WebElement FbbtnLogin = fb.getBtnLogin();
		btn_click(FbbtnLogin);

	}
	
	@Test
	public void loginFB5() throws IOException {
		get_Url("https://www.facebook.com/");
		FBLoginPage fb = new FBLoginPage();
		WebElement FbUserName = fb.getTxtUserName();
		send_Keys(FbUserName, "");
		Assert.assertEquals("User name entered Correctly", getData(1, 0, "FB Login", excelLoc), get_Attribute(FbUserName));

		WebElement FbPassword = fb.getTxtPassword();
		send_Keys(FbPassword, "");
		Assert.assertEquals("Verifying the Password", getData(1, 1, "FB Login", excelLoc), get_Attribute(FbPassword));

		WebElement FbbtnLogin = fb.getBtnLogin();
		btn_click(FbbtnLogin);

	}

}
