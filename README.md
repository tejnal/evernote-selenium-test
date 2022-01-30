# What is this test about ?
evernote-selenium-test repository demonstrate testing the Evernote app using the combination of  java,  selenium, cucumber, bdd and pagefactory design 

##  features that covered part of this test?
2)Logout feature 
3)Create note after login 
4)Revisit the not that create in previous test , verify and move to Trash bin 

# What all the Tech and tooling used for this framework
- Java above 8 
- Maven 
- Intellij 
- Selenium
- Cucumber 
- Chrome diver that i used for his project  [Driver Version] [https://chromedriver.storage.googleapis.com/index.html?path=97.0.4692.71/]
- Gherkin syntax

# Challenges faced while developing framework and testing features?
 - Iframe handling 
 - Slow of the DOM loading causing tests to run as SUITE
 
# Additional feature used
- Reading test properties from configuration properties file -- /evernote-selenium-test/configs/Configuration.properties 
- This framework support Reporting on  HTML format, json junit, Junit

# How to run tests?
- Build project to see any compilation error like wrong JAVA version etc 
- Native to /src/test/java/stepdefs/TestRunner.java click run button side to class
 


