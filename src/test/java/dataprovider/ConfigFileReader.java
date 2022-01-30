package dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

  private final String propertyFilePath = "configs//Configuration.properties";
  private Properties properties;

  public ConfigFileReader() {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(propertyFilePath));
      properties = new Properties();
      try {
        properties.load(reader);
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
    }
  }

  public String getApplicationUrl() {
    String url = properties.getProperty("loginUrl");
    if (url != null) return url;
    else throw new RuntimeException("url not specified in the Configuration.properties file.");
  }

  public String getValidUserName() {
    String username = properties.getProperty("validUsername");
    if (username != null) return username;
    else throw new RuntimeException("username not specified in the Configuration.properties file.");
  }

  public String getInValidUserName() {
    String invalidUsername = properties.getProperty("invalidUsername");
    if (invalidUsername != null) return invalidUsername;
    else
      throw new RuntimeException(
          "invalidUsername not specified in the Configuration.properties file.");
  }

  public String getPassword() {
    String password = properties.getProperty("password");
    if (password != null) return password;
    else throw new RuntimeException("password not specified in the Configuration.properties file.");
  }

  public String getVerificationMessage() {
    String verificationMessage = properties.getProperty("loginFailureVerificationMessage");
    if (verificationMessage != null) return verificationMessage;
    else
      throw new RuntimeException(
          "verificationMessage not specified in the Configuration.properties file.");
  }

  public String getNoteTitle() {
    String noteTitle = properties.getProperty("noteTitle");
    if (noteTitle != null) return noteTitle;
    else
      throw new RuntimeException("noteTitle not specified in the Configuration.properties file.");
  }

  public String getNoteText() {
    String noteText = properties.getProperty("noteText");
    if (noteText != null) return noteText;
    else throw new RuntimeException("noteText not specified in the Configuration.properties file.");
  }
}
