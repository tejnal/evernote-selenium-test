package stepdefs;

import dataprovider.ConfigFileReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class LoginSteps {

  WebDriver driver = null;
  LoginPage loginPage;
  HomePage homePage;
  ConfigFileReader configFileReader;

  @Before
  public void setup() {
    configFileReader= new ConfigFileReader();
    String path = System.getProperty("user.dir");
    String driverPath = path + "/src/test/resources/drivers/chromedriver";
    System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
  }

  @Given("user is on login page")
  public void user_is_on_login_page() {
    driver.navigate().to(configFileReader.getApplicationUrl());
    driver.manage().window().maximize();
  }

  @When("user enters the invalid email address")
  public void user_enters_the_invalid_email_address() {
    loginPage = new LoginPage(driver);
    loginPage.enterUsername(configFileReader.getInValidUserName());
  }

  @When("user click continue button")
  public void user_click_continue_button() {
    loginPage = new LoginPage(driver);
    loginPage.clickContinue();
  }

  @Then("user should get that the notification that the email address is invalid")
  public void user_should_get_that_the_notification_that_the_email_address_is_invalid()
      throws InterruptedException {
    loginPage = new LoginPage(driver);
    loginPage.verifyNotification(configFileReader.getVerificationMessage());
    driver.close();
    driver.quit();
  }

  @When("user enters username and password")
  public void user_enters_username_and_password() {
    loginPage = new LoginPage(driver);
    loginPage.enterUsername(configFileReader.getValidUserName());
    loginPage.clickContinue();
    loginPage.enterPassword(configFileReader.getPassword());
  }

  @When("clicks on login button")
  public void clicks_on_login_button() {
    loginPage = new LoginPage(driver);
    loginPage.clickOnLoginButton();
  }

  @Then("verify login must be successful")
  public void verify_login_must_be_successful() {
    homePage = new HomePage(driver);
    homePage.verifyLoginIsSuccessful();
    driver.close();
    driver.quit();
  }

  @Then("click create a new note")
  public void click_create_a_new_note() {
    homePage = new HomePage(driver);
    homePage.clickOnNewNoteOpen();
  }

  @Then("write a title of the note")
  public void write_a_title_of_the_note() {
    homePage = new HomePage(driver);
    homePage.writeTitleOfTheNote(configFileReader.getNoteTitle());
  }

  @Then("Write some text in note")
  public void write_some_text_in_note() {
    homePage = new HomePage(driver);
    homePage.writeSomeTextInNote(configFileReader.getNoteText());
  }

  @Then("logout form the evernote")
  public void logout_form_the_evernote() {
    homePage = new HomePage(driver);
    homePage.logoutFromEvernoteApp();
    driver.close();
    driver.quit();
  }

  @When("clicks on note created in previous test case")
  public void clicks_on_note_created_in_previous_test_case() throws InterruptedException {
    homePage = new HomePage(driver);
    homePage.clickOnExistingNote();
  }

  @When("verify the content of the note")
  public void verify_the_content_of_the_note() {
    homePage = new HomePage(driver);
    homePage.verifyContentInTheNote(configFileReader.getNoteText());
  }

  @When("move note to trash bin")
  public void move_note_to_trash_bin() {
    homePage = new HomePage(driver);
    homePage.moveNoteToTrash();
  }
}
