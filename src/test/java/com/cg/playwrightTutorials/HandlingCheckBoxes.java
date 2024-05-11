package com.cg.playwrightTutorials;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class HandlingCheckBoxes {
	
	@Test
	public void handlingCheckBoxes() {
		
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
		
		page.locator("//button [text()='SKIP LOGIN']").click();
		
		//checking boxes
		page.getByLabel("Development").check();
		page.check("[value='automation_testing']");
		page.getByLabel("Management").check();
		
		
		//unchecking boxes
		//page.uncheck("[value='automation_testing']");
		page.getByLabel("Development").uncheck();
		
		
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!page.locator("[value='development']").isChecked()) {
			page.locator("[value='development']").check();
			System.out.println("Checked");
		}else {
			System.out.println("Unchecked");
		}
		
		
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
