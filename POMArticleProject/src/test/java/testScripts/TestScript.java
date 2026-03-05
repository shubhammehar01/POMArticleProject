package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.Base;
import pages.DeleteArticle;
import pages.EditArticle;
import pages.CreateArticle;
import pages.Login;

public class TestScript {
	WebDriver driver;
	WebDriverWait wait;

	Login loginPage;
	CreateArticle newArt;
	EditArticle editArt;
	DeleteArticle deleteArt;

	@BeforeClass
	public void setup() {
		driver = Base.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://conduit-realworld-example-app.fly.dev/#/login");

		loginPage = new Login(driver);
		loginPage.login("shubhammehar100@gmail.com", "P@ssw0rd");

		newArt = new CreateArticle(driver);
		editArt = new EditArticle(driver);
		deleteArt = new DeleteArticle(driver);
	}

	@Test(priority = 1)
	public void testCreateArticle() {
		newArt.clickNewArticle();
		newArt.enterArticleDetails("AI StartUp", "AI StartUp Description", "AIStartup Body", "StartUp");
		newArt.publish();
		Assert.assertTrue(newArt.getArticleContent(wait, "AI StartUp").equalsIgnoreCase("AI StartUp"),
				"not match found.");
		
		
	}

	@Test(priority = 2)
	public void testEditArticle() {
		editArt.clickHomepageandglobalfeed();

		editArt.verifyArticle();
		editArt.clickArticle(wait, "AI StartUp");
		editArt.clickEdit();
		editArt.updateContent("EDITED");

		Assert.assertTrue(editArt.getContent().contains("EDITED"));
	}

	@Test(priority = 3)
	public void testDeleteArticle() {
		deleteArt.delete();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div[1]/ul/li[1]")).isDisplayed());
	}

	@AfterClass
	    public void tearDown() {
	        Base.quitDriver();
	}  
}
