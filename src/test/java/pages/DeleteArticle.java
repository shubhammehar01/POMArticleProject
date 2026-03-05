package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteArticle {
	WebDriver driver;
    @FindBy(xpath = "//button[contains(text(),'Delete Article')]")
    WebElement btnDelete;

    public DeleteArticle(WebDriver driver) { 
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }

    public void delete() {
        btnDelete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
