package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	 WebDriver driver;

	    @FindBy(name = "email")
	    WebElement txtEmail;

	    @FindBy(name = "password")
	    WebElement txtPassword;

	    @FindBy(xpath = "//button[text()='Login']")
	    WebElement btnLogin;

	    public Login(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

		public void login(String email, String password) {
	        txtEmail.sendKeys(email);
	        txtPassword.sendKeys(password);
	        btnLogin.click();
	    }
}
