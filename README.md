
EnuygunTestCase

	|_src/test/java
	|	|com.example
	|	|	|_actions
	|	|	|	|_MethodsLibrary
	|	|_page_objects
	|		|_FlightListPage
	|		|_HomePage
	|		|_InformationPage
	|   |_definitions
	|   |   |_FlightPageStepDefinitons
	|   |   |_HomePageStepDefinitons
	|   |   |_InformationPageStepDefinitons
	|   |   |_Hooks
	|	|_runner
    |   |   |_CucumberRunnerTests
	|_src/test/resources
	|	|_features
	|	|	|Case1-SearchFlightTimes.feature
	|	|	|Case2-CheckTHYPricesAreSorted.feature
	|	|	|Case3-PaymentPageControl.feature


The complete list of tools, you can see in the pom.xml file.

Requirements
Java Development Kit
Maven
WebDriver, using ChromeDriver
Cucumber
JUnit
Java21
Allure is installed on the machine (to see report after using "allure serve" in target directory)

Running Tests
Clone the repository  to your directory
Open the project using any Java IDE, preferrably IntelliJ IDEA
Run the tests with the script below or run features directly after maven compilation.
$ mvn clean install

Test Case 1 = Validates if there are any existing flights before 10 AM and after 6 PM.
Test Case 2 = Validates if THY flights are sorted from low price to high.
Test Case 3 = Validates that payment page does open.


1. This framework consists of:
````
Cucumber – 7.15.0
Java 21
JUnit – 4.13.2
Allure Bom - 2.25.0
AspectJ - 1.9.21
Allure Maven - 2.12.0
Maven – 3.9.6
Selenium - 4.16.1
Maven Compiler Plugin - 3.12.1
Maven Surefire Plugin - 3.2.3

````

2. To run the tests, use the below command
````
mvn clean test
````
3. The path of allure-results folder is present in target folder, declared in allure.properties present in **src/test/resources**.</n>

4. Change the path to allure-results by using the below command
````
cd target
````
5. Create the Allure Report by using the below command
````
allure serve
*MAKE SURE ALLURE IS INSTALLED ON THE SYSTEM*
````
