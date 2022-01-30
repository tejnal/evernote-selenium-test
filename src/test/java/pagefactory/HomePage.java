package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

  @FindBy(xpath = "//*[@id='qa-HOME_NOTE_WIDGET_CREATE_NOTE']/p")
  @CacheLookup
  WebElement verifyLoginSuccess;

  @FindBy(id = "qa-HOME_NOTE_WIDGET_CREATE_NOTE")
  @CacheLookup
  WebElement btn_create_note;

  @FindBy(xpath = "/html/body/en-noteheader/div/div[2]/textarea")
  @CacheLookup
  WebElement txt_title;

  @FindBy(xpath = "//*[@id='en-note']/div")
  @CacheLookup
  WebElement txt_note;

  @FindBy(xpath = "//*[@id='qa-NAV_USER']/div/div/span/div/div[1]/div")
  @CacheLookup
  WebElement txt_email_address;

  @FindBy(xpath = "//*[@id='qa-ACCOUNT_DROPDOWN_LOGOUT']/div/span/span")
  @CacheLookup
  WebElement logout;

  @FindBy(xpath = "//*[@id='qa-HOME_NOTE_WIDGET_NOTE_LIST_2|0_0|0_0EUSV1|13']/article[1]/div[1]")
  @CacheLookup
  WebElement existing_note;

  @FindBy(xpath = "//*[@id='qa-NOTE_ACTIONS']")
  @CacheLookup
  WebElement more_actions;

  @FindBy(xpath = "//*[@id='qa-ACTION_DELETE']/div/span/span")
  @CacheLookup
  WebElement move_to_trash_bin;

  public HomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void clickOnNewNoteOpen() {
    btn_create_note.click();
  }

  public void writeTitleOfTheNote(String noteTitle) {
    WebElement iframe = driver.findElement(By.id("qa-COMMON_EDITOR_IFRAME"));
    driver.switchTo().frame(iframe);
    txt_title.sendKeys(noteTitle);
  }

  public void writeSomeTextInNote(String noteText) {
    txt_note.sendKeys(noteText);
  }

  public void logoutFromEvernoteApp() {
    driver.switchTo().parentFrame();
    txt_email_address.click();
    logout.click();
  }

  public void clickOnExistingNote() throws InterruptedException {
      Thread.sleep(3000);
    existing_note.click();
    Thread.sleep(5000);
  }

  public void verifyContentInTheNote(String message) {
    WebElement iframe = driver.findElement(By.id("qa-COMMON_EDITOR_IFRAME"));
    driver.switchTo().frame(iframe);
    if (!driver.getPageSource().contains(message)) {
      throw new IllegalStateException(
          "This is not note text that we are looking for. The Current page is" + driver.getCurrentUrl());
    }
    driver.switchTo().parentFrame();
  }

  public void moveNoteToTrash() {
    more_actions.click();
    move_to_trash_bin.click();
  }

  public void verifyLoginIsSuccessful() {
    verifyLoginSuccess.isDisplayed();
    if (!driver.getPageSource().contains("Create new note")) {
      throw new IllegalStateException(
          "This is not login success page. The Current page is" + driver.getCurrentUrl());
    }
  }
}
