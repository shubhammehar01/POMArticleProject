package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateArticle {
    WebDriver driver;
    @FindBy(partialLinkText = "New Article")
    WebElement navNewArticle;

    @FindBy(css = "input[name='title']")
    WebElement txtTitle;

    @FindBy(css = "input[name='description']")
    WebElement txtDesc;

    @FindBy(css = "textarea[placeholder*='Write your article (in markdown)']")
    WebElement txtBody;

    @FindBy(css = "input[name='tags']")
    WebElement txtTags;

    @FindBy(xpath = "//button[text()='Publish Article']")
    WebElement btnPublish;
    
    @FindBy(xpath = "//*[@id='root']//h1")
    WebElement lblArticleContent;

    public CreateArticle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickNewArticle() {
        navNewArticle.click();
    }
    public void enterArticleDetails(String title, String desc, String body, String tags) {
        txtTitle.sendKeys(title);
        txtDesc.sendKeys(desc);
        txtBody.sendKeys(body);
        txtTags.sendKeys(tags);
    }
    public void publish() {
        btnPublish.click();
    }
    
    public String getArticleContent(WebDriverWait wait, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(lblArticleContent, expectedText));
        return lblArticleContent.getText();
    }
}
