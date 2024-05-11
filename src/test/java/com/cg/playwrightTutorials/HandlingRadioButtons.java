package com.cg.playwrightTutorials;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class HandlingRadioButtons {
	
	@Test
	public void handleRadiobuttons() {
		
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
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//page.click("//button [text()='SKIP LOGIN']");
		page.locator("//button [text()='SKIP LOGIN']").click();
		//page.check("[value='Female']");
		//page.getByLabel("Female").check();
		page.locator("[value='Male']").check();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		page.close();
		browser.close();
		playwright.close();
		
		
		
		
	}

}
