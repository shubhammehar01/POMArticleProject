package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditArticle {
	 WebDriver driver;
 
   @FindBy(linkText = "Home")
   WebElement lnkHome;

   @FindBy(xpath = "//button[text()='Global Feed']")
   WebElement btnGlobalFeed;

   @FindBy(xpath = "//span[contains(text(),'2026')]")
   WebElement lblYear2026;

   @FindBy(linkText = "Edit Article")
   WebElement btnEdit;

   @FindBy(css = "textarea[placeholder='Write your article (in markdown)']")
   WebElement txtBody;

   @FindBy(xpath = "//button[text()='Update Article']")
   WebElement btnUpdate;
   
   @FindBy(xpath = "//div[@class='article-page']//p")
   WebElement lblArticleContent;
   
   @FindAll({
       @FindBy(how = How.CSS, using = "a.preview-link")
   })
   List<WebElement> articlePreviews;
   
   

   public EditArticle(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }
   public void clickHomepageandglobalfeed() {
       lnkHome.click();
       btnGlobalFeed.click();
   }

   public void verifyArticle() {
       if (lblYear2026.getText().contains("2026")) {
           System.out.println("Article Created");
       } else {
           System.out.println("Article Not Created.");
       }
   }

   public void clickArticle(WebDriverWait wait,String expectedTitle) {
   	
   	wait.until(ExpectedConditions.visibilityOfAllElements(articlePreviews));
       for (WebElement preview : articlePreviews) {
           if (preview.getText().trim().contains(expectedTitle)) {
               preview.click();
               break;
           }
       }	
   }

   public void clickEdit() {
       btnEdit.click();
   }

   public void updateContent(String extraText) {
       txtBody.sendKeys(extraText);
       btnUpdate.click();
   }
   
   public String getContent() {
       return lblArticleContent.getText();
   }
}
