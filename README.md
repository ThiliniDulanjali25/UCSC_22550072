PREREQUISITES

1.Make sure below Software are installed in your environment

•   Java Development Kit (JDK 21)  : https://www.oracle.com/java/technologies/downloads/#java21
•   Apache Maven (3.9.9)           : https://maven.apache.org/download.cgi

2.Folder Structure
•   Assignment03_22550072/src/test/java/Base    : Contains Base class.
•	Assignment03_22550072/src/test/java/Config  : Contains Configuration file.
•	Assignment03_22550072/src/test/java/Pages   : Contains Page objects.
•	Assignment03_22550072/src/test/java/TestCases: Contains Testcases.
•	Assignment03_22550072/src/test/java/Utils   : Contains Utility classes (take screenshot, handle excel).
•	Assignment03_22550072/src/test/resources    : Contains Test data, Screenshots, and TestNGSuits.
•	Assignment03_22550072/pom.xml               : Maven configuration file for dependency management.
•	Assignment03_22550072/reports               : Contains Extent reports.

3.Update configuration file.

•   username and password : with your eBay login credentials.
•   browserType : with your preferred browser (chrome/firefox)

4.To change Test data go to TestData excel in Assignment03_22550072/src/test/resources/TestData

5.To change locators or methods goto Page objects in Assignment03_22550072/src/test/java/Pages

6.To change testcases goto Test cases in Assignment03_22550072/src/test/java/TestCases

7.To disable headless browser automation go to "BaseTest.java" class
•   Comment below code
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
driver = new ChromeDriver(chromeOptions);



