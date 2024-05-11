package com.cg.playwrightTutorials;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class HandlingButtons {


	@Test
	public void handleButtons() throws InterruptedException {

		Playwright playwright = Playwright.create();
		//		Page page = playwright.chromium()
		//				.launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false)
				);
		BrowserContext context = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(1366, 768));
		Page page = context.newPage();
		page.navigate("http://dev.automationtesting.in/");
		Thread.sleep(4000);
		//page.click("//button [text()='SKIP LOGIN']");
		page.locator("//button [text()='SKIP LOGIN']").click();
		//page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SKIP LOGIN")).click();
		Thread.sleep(2000);
		
		page.close();
		browser.close();
		playwright.close();

	}


}
