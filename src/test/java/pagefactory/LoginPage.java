package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

  @FindBy(id = "username")
  @CacheLookup
  WebElement txt_username;

  @FindBy(id = "loginButton")
  @CacheLookup
  WebElement btn_continue;

  @FindBy(id = "responseMessage")
  @CacheLookup
  WebElement txt_notification;

  @FindBy(id = "password")
  @CacheLookup
  WebElement txt_password;

  @FindBy(id = "loginButton")
  @CacheLookup
  WebElement btn_signin;

  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void enterUsername(String username) {
    txt_username.sendKeys(username);
  }

  public void enterPassword(String password) {
    txt_password.sendKeys(password);
  }

  public void clickContinue() {
    btn_continue.click();
  }

  public void verifyNotification(String message) throws InterruptedException {
    txt_notification.isDisplayed();
    Thread.sleep(5000);
    if (!driver
        .getPageSource()
        .contains(message)) {
      throw new IllegalStateException(
          "This is not login page. The Current page is" + driver.getCurrentUrl());
    }
  }

  public void clickOnLoginButton() {
    btn_signin.click();
  }
}
