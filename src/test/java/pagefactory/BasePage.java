package pagefactory;


import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {

  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
}
