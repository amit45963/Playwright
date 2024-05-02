package com.cg.Playwright1;

import com.microsoft.playwright.Browser;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowserContext {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://ecommerce-playground.lambdatest.io/index.php");
		Locator myAccount = page.locator("//a[contains(.,'My account')][@role='button']");
		myAccount.hover();
		//	page.click("//a[contains(.,'Login')]");
		page.locator("//a[contains(.,'Login')]").click();
		assertThat(page).hasTitle("Account Login");
		page.fill("input[name='email']", "koushik350@gmail.com");
		page.fill("input[name='password']", "Pass123$");
		//page.getByPlaceholder("E-Mail Address").type("koushik350@gmail.com");
		//page.getByPlaceholder("Password").type("Pass123$");
		page.locator("//input[@value='Login']").click();

		//get the title of the page
		String title = page.title();
		System.out.println("Page Title: " + title);

		assertThat(page).hasTitle("My Account");
		page.close();
		browser.close();
		playwright.close();
	}


}
