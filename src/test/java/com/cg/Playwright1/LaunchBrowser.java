package com.cg.Playwright1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {
	
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false)
				);
		//BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1366, 768));
		Page page = context.newPage();
		
		
		//navigate to a url
		page.navigate("https://www.orangehrm.com/");


		//get the title of the page
		String title = page.title();
		System.out.println("Page Title: " + title);


		//assert the title of the page
		assertThat(page).hasTitle("Human Resources Management Software | OrangeHRM");

		page.close();
		browser.close();
		playwright.close();
	}

}
