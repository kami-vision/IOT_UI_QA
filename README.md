# IOT-mobile-test-automation

### Maven based Test Automation project (For Mobile Apps, having Capabilities of Desktop Web as well as Mobile Web) 

## Salient Features (Done as well as Drafts )

1. Integrated Framework for web/mobile ( web, mobile web & mobile Apps created)
2. Lombok for getters/setters (provided)
3. Configs provided for entry as well as per country & Platform (both provided)
4. TestNg Tests havin Allure Step Features to denote BDD
5. Retry Listener provided for handling flaky tests( available but disabled for now )
6. Flow to move from Web to Mobile and vice versa provided ( provided )
7. Control points at Pom, TestNg.xml as well as Config/Properties files ( provided )
8. Logging provided, standard Log4j + a cumulative log file for overall automation runs combined ( provided )
9. Basic Utils or interacting with Web/Mobile/API calls ( UI Helper as an example )
10. Parsers for various format file reading/writing ( Some done, lot more to cover )
11. Assertion wrapping ( To Be Done )
12. Parallelization ( Done )
a) Mobile will use per user sessions at Cloud Solution
b) Web/Mobile(Local) can use forks via Maven-surefire 
( dependency added, to be tested once we have enough workflow in place )
13. Perfecto Integration Done
14. Perfecto execution trigger from CI like Bitbucket Pipeline or Jenkins or Github CI ( In Progress for Android Build Pipeline )
15. Grouping/Ordered execution of Features/Test -  Cap there, need to showcase with example (Groups Added, Selective TestNg created)
16. Priority execution ( Added )

**How to Setup Locally**

#### 1. Please clone the project from 
 ##### A) Location - https://github.com/kami-vision/IOT_UI_QA.git
 
 ##### B) Git/Bitbucket - git clone git@github.com:kami-vision/IOT_UI_QA.git

#### 2. Import pom.xml as project in your preferred IDE ( Same as any pom/maven project)

#### 3. Install Appium in your system via installer online or command-line (either way is fine)
note: If you have not installed nodeJs, please install that.   

#### 4. Install one of the emulator provider such as AVD-Manager for Android , or GenyMotion to target particular device list

#### 5. In Case of physical device, directly connect device with "developer option" & debug mode enabled

#### 6. Up the Appium Server by command-line like "appium" or from UI installed ( either way is fine)

#### 7. There is a programmatic way as well provided to up Appium Server which will be enabled post simple demo on local machine

###### Run below commands to execute android testng test: ( prefer using emulator or device up to Android API 28 )

$ mvn clean compile ( to build pom in order to download dependencies )

$ mvn test -Dos=android -Dexecution=LOCAL -Dsurefire.suiteXmlFiles=yourTestngFile.xml

###### Run below commands to execute iOS testng test:

$ mvn test -Dos=iOS -Dexecution=LOCAL -Dsurefire.suiteXmlFiles=yourTestngFile.xml

##### Run below commands to execute Web test: ( test to be added, but browser will launch on this)
$ mvn test -Dos=web -Dexecution=LOCAL -Dsurefire.suiteXmlFiles=yourTestngFile.xml

#### 8. Device/Emulator-Device capabilities are consumed in class "CreateSession" having createDriver methods
(For now you can change them there directly to test,
 most of them are already moved to Property Files, either Locale Specific or Global Config file )  

#### 9 By following above steps you should be able to see execution of basic one workflow of Metlife Upwise Mobile APP-QA/Debug version
 
#### 10 LogFile.txt will be generated having details of execution, Also same will be visible in console. Allure Reporting also Added
 
#### Few topics and helpers can be found also here
 Confluence Link to be Updated
 
# Framework Explained: 

## 1. Conceptual:
*  `Driver is kept generic WebDriver to handle workflows across mobile/web calls ` 
* `Driver is casted to Android/IOS as and when needed for specific mobile actions `
* `StepDefinition Files are coupled with particular Screen/Page of the application`
* `Screen classes will have locators of the particular screen`
* `While there is no common locator across web/mobile(ios/android), but there exists common business logic among these`
* `Hence
 SD files will have per screen one common file which will be extended by particular implementation further such as
  android, IOS, web ONLY where logic differs or part which differs - i.e. All the common logic/PageActions remain in
   that particular screen's common SD file`

## TBD ( To be updated )
## 2. Components:
**CreateSession.java** : All the methods to create a new session and destroy the session after the test(s) execution is
 over. Each test extends this class. Below are the methods in CreateSession class in their execution order.
 
**GenericMethods.java** : It is a common repository for all the  webdriver and appium methods which are called in
 each coreLogic classes. Every new method which is being used in coreLogic classes should be added in this class as well.
  It is to reduce the duplicate code. Each screen class extends this class. Below are few methods defined in this class:

**Package : app** : It contains the app build against which tests would be executed. 

**Package : config** - It contains three files config.properties, android_config.properties and iOS_config.properties.

**config.properties** : Path to android and iOS config files are defined in this file. Other common required values
 like DB connection information etc. could be written in this file.  
 
 ## 3. Running Options:
 ** Run Locally **
 Examples
 mvn test -Dos=android -Dsurefire.suiteXmlFiles=testng.xml -Dexecution=LOCAL -DLOCALE=en_US
  ( running US android app with execution mode LOCAL )
  
  mvn test -Dos=iOS -Dsurefire.suiteXmlFiles=testng.xml -Dexecution=LOCAL -DLOCALE=en_US
   ( running US iOS ipa with execution mode LOCAL )
   
   mvn test -Dos=web -Dsurefire.suiteXmlFiles=testng.xml -Dexecution=LOCAL -DLOCALE=en_US
   ( running on web with execution mode LOCAL )
 
 
 ** Run on Perfecto Cloud **
 Examples
 mvn test -Dos=android -Dsurefire.suiteXmlFiles=testng.xml -Dexecution=PERFECTO -DLOCALE=en_US
 ( running US android app with execution mode PERFECTO )
 
 mvn test -Dos=iOS -Dsurefire.suiteXmlFiles=testng.xml -Dexecution=PERFECTO -DLOCALE=en_US
  ( running US iOS ipa with execution mode PERFECTO )
  
  ## 4. How to build Xcode Simulator in your local using Source Code
  Please refer following link describing setup:
  To be updated with Confluence Link
  
  ## 5. CI jobs:
  All the jenkins jobs related to running web/Mobile scripts using this repo are located at:
  To be Updated once created
  
  
 
