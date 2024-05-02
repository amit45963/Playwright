package com.cg.Playwright1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class BookAppointment {
	
	
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://www.orangehrm.com/");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("OrangeHRM Logo")).click();
			page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Peace of mind is just a few")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book a Free Demo")).click();
			page.getByPlaceholder("Your Full Name*").click();
			page.getByPlaceholder("Your Full Name*").fill("Amit");
			page.getByPlaceholder("Business Email*").click();
			page.getByPlaceholder("Business Email*").fill("mau@bbdi.com");
			page.getByPlaceholder("Company Name").click();
			page.getByPlaceholder("Company Name").fill("hgygyyyg");
			page.getByLabel("Country").selectOption("India");
			page.getByPlaceholder("Phone Number*").click();
			page.getByPlaceholder("Phone Number*").fill("8668776575");
			//page.frameLocator("iframe[name=\"a-aok7nk8ekh6l\"]").getByLabel("I'm not a robot").click();
			//page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get a Free Demo")).click();
		}
	}
	

}
